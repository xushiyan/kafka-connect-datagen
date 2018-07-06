``message.template``
  Message template to be used for each message.

  * Type: string
  * Importance: high

``poll.interval.ms``
  Time interval (ms) between two polls.

  * Type: int
  * Importance: high

``poll.size``
  Number of messages to be sent in one poll.

  * Type: int
  * Importance: high

``random.fields``
  List of fields to be randomized.

  * Type: list
  * Importance: high

``topic``
  Kafka topic

  * Type: string
  * Importance: high

``test.mode``
  Indicator for test mode: either 'performance' or integration'

  * Type: string
  * Default: performance
  * Importance: high

``event.timestamp.field``
  Field for storing event timestamp.

  * Type: string
  * Default: ts
  * Importance: medium

