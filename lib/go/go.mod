module github.com/Workiva/frugal/lib/go

require (
	git.apache.org/thrift.git v0.13.0
	github.com/Sirupsen/logrus v0.11.5
	github.com/go-stomp/stomp v2.0.6+incompatible
	github.com/mattrobenolt/gocql v0.0.0-20130828033103-56c5a46b65ee
	github.com/nats-io/gnatsd v1.4.1
	github.com/nats-io/go-nats v0.0.0-20161120202126-6b6bf392d34d
	github.com/nats-io/nuid v1.0.1 // indirect
	github.com/stretchr/testify v1.6.1
	golang.org/x/crypto v0.0.0-20200820211705-5c72a883971a // indirect
)

replace git.apache.org/thrift.git => github.com/apache/thrift v0.13.0