#
# Autogenerated by Frugal Compiler (1.19.1)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#



from datetime import timedelta
from threading import Lock

from frugal.exceptions import FRateLimitException
from frugal.middleware import Method
from frugal.processor import FBaseProcessor
from frugal.processor import FProcessorFunction
from frugal.registry import FClientRegistry
from thrift.Thrift import TApplicationException
from thrift.Thrift import TMessageType
from tornado import gen
from tornado.concurrent import Future

from v1.music.Store import *
from v1.music.ttypes import *


class Iface(object):
    """
    Services are the API for client and server interaction.
    Users can buy an album or enter a giveaway for a free album.
    """

    def buyAlbum(self, ctx, ASIN, acct):
        """
        Args:
            ctx: FContext
            ASIN: string
            acct: string
        """
        pass

    def enterAlbumGiveaway(self, ctx, email, name):
        """
        Args:
            ctx: FContext
            email: string
            name: string
        """
        pass


class Client(Iface):

    def __init__(self, transport, protocol_factory, middleware=None):
        """
        Create a new Client with a transport and protocol factory.

        Args:
            transport: FTransport
            protocol_factory: FProtocolFactory
            middleware: ServiceMiddleware or list of ServiceMiddleware
        """
        if middleware and not isinstance(middleware, list):
            middleware = [middleware]
        transport.set_registry(FClientRegistry())
        self._transport = transport
        self._protocol_factory = protocol_factory
        self._oprot = protocol_factory.get_protocol(transport)
        self._write_lock = Lock()
        self._methods = {
            'buyAlbum': Method(self._buyAlbum, middleware),
            'enterAlbumGiveaway': Method(self._enterAlbumGiveaway, middleware),
        }

    def buyAlbum(self, ctx, ASIN, acct):
        """
        Args:
            ctx: FContext
            ASIN: string
            acct: string
        """
        return self._methods['buyAlbum']([ctx, ASIN, acct])

    @gen.coroutine
    def _buyAlbum(self, ctx, ASIN, acct):
        delta = timedelta(milliseconds=ctx.get_timeout())
        callback_future = Future()
        timeout_future = gen.with_timeout(delta, callback_future)
        self._transport.register(ctx, self._recv_buyAlbum(ctx, callback_future))
        try:
            yield self._send_buyAlbum(ctx, ASIN, acct)
            result = yield timeout_future
        finally:
            self._transport.unregister(ctx)
        raise gen.Return(result)

    @gen.coroutine
    def _send_buyAlbum(self, ctx, ASIN, acct):
        oprot = self._oprot
        with self._write_lock:
            oprot.write_request_headers(ctx)
            oprot.writeMessageBegin('buyAlbum', TMessageType.CALL, 0)
            args = buyAlbum_args()
            args.ASIN = ASIN
            args.acct = acct
            args.write(oprot)
            oprot.writeMessageEnd()
            yield oprot.get_transport().flush()

    def _recv_buyAlbum(self, ctx, future):
        def buyAlbum_callback(transport):
            iprot = self._protocol_factory.get_protocol(transport)
            iprot.read_response_headers(ctx)
            _, mtype, _ = iprot.readMessageBegin()
            if mtype == TMessageType.EXCEPTION:
                x = TApplicationException()
                x.read(iprot)
                iprot.readMessageEnd()
                if x.type == FRateLimitException.RATE_LIMIT_EXCEEDED:
                    future.set_exception(FRateLimitException(x.message))
                    return
                future.set_exception(x)
                raise x
            result = buyAlbum_result()
            result.read(iprot)
            iprot.readMessageEnd()
            if result.error is not None:
                future.set_exception(result.error)
                return
            if result.success is not None:
                future.set_result(result.success)
                return
            x = TApplicationException(TApplicationException.MISSING_RESULT, "buyAlbum failed: unknown result")
            future.set_exception(x)
            raise x
        return buyAlbum_callback

    def enterAlbumGiveaway(self, ctx, email, name):
        """
        Args:
            ctx: FContext
            email: string
            name: string
        """
        return self._methods['enterAlbumGiveaway']([ctx, email, name])

    @gen.coroutine
    def _enterAlbumGiveaway(self, ctx, email, name):
        delta = timedelta(milliseconds=ctx.get_timeout())
        callback_future = Future()
        timeout_future = gen.with_timeout(delta, callback_future)
        self._transport.register(ctx, self._recv_enterAlbumGiveaway(ctx, callback_future))
        try:
            yield self._send_enterAlbumGiveaway(ctx, email, name)
            result = yield timeout_future
        finally:
            self._transport.unregister(ctx)
        raise gen.Return(result)

    @gen.coroutine
    def _send_enterAlbumGiveaway(self, ctx, email, name):
        oprot = self._oprot
        with self._write_lock:
            oprot.write_request_headers(ctx)
            oprot.writeMessageBegin('enterAlbumGiveaway', TMessageType.CALL, 0)
            args = enterAlbumGiveaway_args()
            args.email = email
            args.name = name
            args.write(oprot)
            oprot.writeMessageEnd()
            yield oprot.get_transport().flush()

    def _recv_enterAlbumGiveaway(self, ctx, future):
        def enterAlbumGiveaway_callback(transport):
            iprot = self._protocol_factory.get_protocol(transport)
            iprot.read_response_headers(ctx)
            _, mtype, _ = iprot.readMessageBegin()
            if mtype == TMessageType.EXCEPTION:
                x = TApplicationException()
                x.read(iprot)
                iprot.readMessageEnd()
                if x.type == FRateLimitException.RATE_LIMIT_EXCEEDED:
                    future.set_exception(FRateLimitException(x.message))
                    return
                future.set_exception(x)
                raise x
            result = enterAlbumGiveaway_result()
            result.read(iprot)
            iprot.readMessageEnd()
            if result.success is not None:
                future.set_result(result.success)
                return
            x = TApplicationException(TApplicationException.MISSING_RESULT, "enterAlbumGiveaway failed: unknown result")
            future.set_exception(x)
            raise x
        return enterAlbumGiveaway_callback


class Processor(FBaseProcessor):

    def __init__(self, handler, middleware=None):
        """
        Create a new Processor.

        Args:
            handler: Iface
        """
        if middleware and not isinstance(middleware, list):
            middleware = [middleware]

        super(Processor, self).__init__()
        self.add_to_processor_map('buyAlbum', _buyAlbum(Method(handler.buyAlbum, middleware), self.get_write_lock()))
        self.add_to_processor_map('enterAlbumGiveaway', _enterAlbumGiveaway(Method(handler.enterAlbumGiveaway, middleware), self.get_write_lock()))


class _buyAlbum(FProcessorFunction):

    def __init__(self, handler, lock):
        self._handler = handler
        self._lock = lock

    @gen.coroutine
    def process(self, ctx, iprot, oprot):
        args = buyAlbum_args()
        args.read(iprot)
        iprot.readMessageEnd()
        result = buyAlbum_result()
        try:
            result.success = yield gen.maybe_future(self._handler([ctx, args.ASIN, args.acct]))
        except PurchasingError as error:
            result.error = error
        except FRateLimitException as ex:
            with self._lock:
                _write_application_exception(ctx, oprot, FRateLimitException.RATE_LIMIT_EXCEEDED, "buyAlbum", ex.message)
                return
        with self._lock:
            oprot.write_response_headers(ctx)
            oprot.writeMessageBegin('buyAlbum', TMessageType.REPLY, 0)
            result.write(oprot)
            oprot.writeMessageEnd()
            oprot.get_transport().flush()


class _enterAlbumGiveaway(FProcessorFunction):

    def __init__(self, handler, lock):
        self._handler = handler
        self._lock = lock

    @gen.coroutine
    def process(self, ctx, iprot, oprot):
        args = enterAlbumGiveaway_args()
        args.read(iprot)
        iprot.readMessageEnd()
        result = enterAlbumGiveaway_result()
        try:
            result.success = yield gen.maybe_future(self._handler([ctx, args.email, args.name]))
        except FRateLimitException as ex:
            with self._lock:
                _write_application_exception(ctx, oprot, FRateLimitException.RATE_LIMIT_EXCEEDED, "enterAlbumGiveaway", ex.message)
                return
        with self._lock:
            oprot.write_response_headers(ctx)
            oprot.writeMessageBegin('enterAlbumGiveaway', TMessageType.REPLY, 0)
            result.write(oprot)
            oprot.writeMessageEnd()
            oprot.get_transport().flush()


def _write_application_exception(ctx, oprot, type, method, message):
    x = TApplicationException(type=type, message=message)
    oprot.write_response_headers(ctx)
    oprot.writeMessageBegin(method, TMessageType.EXCEPTION, 0)
    x.write(oprot)
    oprot.writeMessageEnd()
    oprot.get_transport().flush()


