``topic.name``
  Name of the Kafka topic to publish data to.

  * Type: string
  * Importance: high

``poll.size``
  Number of messages to be sent in one poll.

  * Type: int
  * Default: 1
  * Importance: medium

``poll.interval.ms``
  Time interval (ms) between two polls.

  * Type: int
  * Default: 10000
  * Importance: medium

``message.template``
  Message template to be used for each message.

  * Type: string
  * Importance: medium

``random.fields``
  List of fields to be randomized.

  * Type: list
  * Importance: medium

``event.timestamp.field``
  Name of the field to store event timestamp.

  * Type: string
  * Default: ts
  * Importance: low

