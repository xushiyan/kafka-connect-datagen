# kafka-connect-datagen

[![Build Status](https://travis-ci.org/xushiyan/kafka-connect-datagen.svg?branch=master)](https://travis-ci.org/xushiyan/kafka-connect-datagen)

`kafka-connect-datagen` is a [Kafka Connect](http://kafka.apache.org/documentation.html#connect) plugin that generates test data for performance and integration tests.

## Configurations

| Key | Notes | Default Value |
|:----|-------|:-------------:|
| `topic`                 | Kafka topic to send data to ||
| `test.mode`             | To indicate test setup type: `performance` or `integration`| `performance`|
| `poll.size`             | Number of messages sent in one batch | |
| `poll.interval.ms`      | Time interval between two batches | |
| `message.template`      | Template to be used for each message | |
| `random.field`          | Field to be randomized | |
| `random.field.values`   | Comma-delimited possible values for the specified random field | |
| `event.timestamp.field` | Field for storing event timestamp | `ts` |

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

- Multiple random fields
- Integration test mode
- Config validation
- JSON schema support
- Protobuf support
