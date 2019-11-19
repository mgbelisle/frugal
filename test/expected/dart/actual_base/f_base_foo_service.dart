// Autogenerated by Frugal Compiler (3.4.10)
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING



// ignore_for_file: unused_import
// ignore_for_file: unused_field
import 'dart:async';
import 'dart:typed_data' show Uint8List;

import 'package:logging/logging.dart' as logging;
import 'package:thrift/thrift.dart' as thrift;
import 'package:frugal/frugal.dart' as frugal;

import 'package:actual_base_dart/actual_base_dart.dart' as t_actual_base_dart;


abstract class FBaseFoo {
  Future basePing(frugal.FContext ctx);
}

class FBaseFooClient implements FBaseFoo {
  static final logging.Logger _frugalLog = logging.Logger('BaseFoo');
  Map<String, frugal.FMethod> _methods;

  FBaseFooClient(frugal.FServiceProvider provider, [List<frugal.Middleware> middleware]) {
    _transport = provider.transport;
    _protocolFactory = provider.protocolFactory;
    var combined = middleware ?? [];
    combined.addAll(provider.middleware);
    this._methods = {};
    this._methods['basePing'] = frugal.FMethod(this._basePing, 'BaseFoo', 'basePing', combined);
  }

  frugal.FTransport _transport;
  frugal.FProtocolFactory _protocolFactory;

  @override
  Future basePing(frugal.FContext ctx) {
    return this._methods['basePing']([ctx]);
  }

  Future _basePing(frugal.FContext ctx) async {
    var memoryBuffer = frugal.TMemoryOutputBuffer(_transport.requestSizeLimit);
    var oprot = _protocolFactory.getProtocol(memoryBuffer);
    oprot.writeRequestHeader(ctx);
    oprot.writeMessageBegin(thrift.TMessage('basePing', thrift.TMessageType.CALL, 0));
    basePing_args args = basePing_args();
    args.write(oprot);
    oprot.writeMessageEnd();
    var response = await _transport.request(ctx, memoryBuffer.writeBytes);

    var iprot = _protocolFactory.getProtocol(response);
    iprot.readResponseHeader(ctx);
    thrift.TMessage msg = iprot.readMessageBegin();
    if (msg.type == thrift.TMessageType.EXCEPTION) {
      thrift.TApplicationError error = thrift.TApplicationError.read(iprot);
      iprot.readMessageEnd();
      if (error.type == frugal.FrugalTTransportErrorType.REQUEST_TOO_LARGE) {
        throw thrift.TTransportError(
            frugal.FrugalTTransportErrorType.RESPONSE_TOO_LARGE, error.message);
      }
      throw error;
    }

    basePing_result result = basePing_result();
    result.read(iprot);
    iprot.readMessageEnd();
  }
}

// ignore: camel_case_types
class basePing_args implements thrift.TBase {
  static final thrift.TStruct _STRUCT_DESC = thrift.TStruct('basePing_args');



  basePing_args();

  @override
  getFieldValue(int fieldID) {
    switch (fieldID) {
      default:
        throw ArgumentError("Field $fieldID doesn't exist!");
    }
  }

  @override
  setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
      default:
        throw ArgumentError("Field $fieldID doesn't exist!");
    }
  }

  // Returns true if the field corresponding to fieldID is set (has been assigned a value) and false otherwise
  @override
  bool isSet(int fieldID) {
    switch (fieldID) {
      default:
        throw ArgumentError("Field $fieldID doesn't exist!");
    }
  }

  @override
  read(thrift.TProtocol iprot) {
    iprot.readStructBegin();
    for (thrift.TField field = iprot.readFieldBegin();
        field.type != thrift.TType.STOP;
        field = iprot.readFieldBegin()) {
      switch (field.id) {
        default:
          thrift.TProtocolUtil.skip(iprot, field.type);
          break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  @override
  write(thrift.TProtocol oprot) {
    validate();

    oprot.writeStructBegin(_STRUCT_DESC);
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @override
  String toString() {
    StringBuffer ret = StringBuffer('basePing_args(');

    ret.write(')');

    return ret.toString();
  }

  @override
  bool operator ==(Object o) {
    return o is basePing_args;
  }

  @override
  int get hashCode {
    var value = 17;
    return value;
  }

  basePing_args clone() {
    return basePing_args();
  }

  validate() {
    // check for required fields
    // check that fields of type enum have valid values
  }
}
// ignore: camel_case_types
class basePing_result implements thrift.TBase {
  static final thrift.TStruct _STRUCT_DESC = thrift.TStruct('basePing_result');



  basePing_result();

  @override
  getFieldValue(int fieldID) {
    switch (fieldID) {
      default:
        throw ArgumentError("Field $fieldID doesn't exist!");
    }
  }

  @override
  setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
      default:
        throw ArgumentError("Field $fieldID doesn't exist!");
    }
  }

  // Returns true if the field corresponding to fieldID is set (has been assigned a value) and false otherwise
  @override
  bool isSet(int fieldID) {
    switch (fieldID) {
      default:
        throw ArgumentError("Field $fieldID doesn't exist!");
    }
  }

  @override
  read(thrift.TProtocol iprot) {
    iprot.readStructBegin();
    for (thrift.TField field = iprot.readFieldBegin();
        field.type != thrift.TType.STOP;
        field = iprot.readFieldBegin()) {
      switch (field.id) {
        default:
          thrift.TProtocolUtil.skip(iprot, field.type);
          break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  @override
  write(thrift.TProtocol oprot) {
    validate();

    oprot.writeStructBegin(_STRUCT_DESC);
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @override
  String toString() {
    StringBuffer ret = StringBuffer('basePing_result(');

    ret.write(')');

    return ret.toString();
  }

  @override
  bool operator ==(Object o) {
    return o is basePing_result;
  }

  @override
  int get hashCode {
    var value = 17;
    return value;
  }

  basePing_result clone() {
    return basePing_result();
  }

  validate() {
    // check for required fields
    // check that fields of type enum have valid values
  }
}
