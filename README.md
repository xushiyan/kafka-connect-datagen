# Kafka Connect Datagen Connector

[![Build Status](https://travis-ci.org/xushiyan/kafka-connect-datagen.svg?branch=master)](https://travis-ci.org/xushiyan/kafka-connect-datagen)
[![Documentation Status](https://readthedocs.org/projects/kafka-connect-datagen/badge/?version=latest)](https://kafka-connect-datagen.readthedocs.io/en/latest/?badge=latest)


`kafka-connect-datagen` is a [Kafka Connect](http://kafka.apache.org/documentation.html#connect) plugin that generates data for integration and performance tests.

The documentation is hosted on [readthedocs.org](http://kafka-connect-datagen.rtfd.io/).

## Use as Kafka Connect plugin

- Import as maven project
- Generate jar file
  ```bash
  mvn clean package
  ```

  The jar file (plugin) will be generated under `target/` folder with name like 

  ```text
  kafka-connect-datagen-{version}-jar-with-dependencies.jar
  ```

- To use the connector, put the jar file to a Kafka Connect worker's classpath
- Create tasks for this connector by setting configurations. See [example here](./example/DatagenSourceConnector.properties).

## TODO

- Integration test mode
- Config validation
- JSON schema support
- Protobuf support

# Contribute

- Documentation: http://kafka-connect-datagen.rtfd.io
- Source Code: https://github.com/xushiyan/kafka-connect-datagen

# License

[Apache License 2.0](./LICENSE)
