Quick Start
===========

* Go to ``example/quickstart/`` and start all services

  .. code-block:: bash

    docker-compose up -d

* Run ``docker-compose ps`` to see all services' states

  .. code-block:: text

    Name                            Command                     State   Ports
    --------------------------------------------------------------------------------------------------------------
    quickstart_broker_1             /etc/confluent/docker/run   Up      0.0.0.0:9092->9092/tcp
    quickstart_connect_1            /etc/confluent/docker/run   Up      0.0.0.0:8083->8083/tcp, 9092/tcp
    quickstart_kafka-connect-ui_1   /run.sh                     Up      0.0.0.0:8001->8000/tcp
    quickstart_kafka-rest-proxy_1   /etc/confluent/docker/run   Up      0.0.0.0:8082->8082/tcp
    quickstart_kafka-topics-ui_1    /run.sh                     Up      0.0.0.0:8000->8000/tcp
    quickstart_zookeeper_1          /etc/confluent/docker/run   Up      0.0.0.0:2181->2181/tcp, 2888/tcp, 3888/tcp

  *Wait for Kafka Broker and Kafka Connect cluster to be fully started.*

    * Check https://localhost:8000 to see the Broker UI
    * Check https://localhost:8001 to see the Connect UI

* Create data generation task

  .. code-block:: bash

    curl -X POST http://localhost:8083/connectors \
    -H 'Content-Type:application/json' \
    -H 'Accept:application/json' \
    -d @connect.source.datagen.json | jq

* Based on the configurations, you should observe from Broker UI that

  * messages are being published to topic ``generated.events`` at rate of 10 every 5 seconds
  * every message is randomized over ``status`` and ``direction`` fields
  * every message contains a timestamp field ``event_ts``

* Go to Connect UI, select the "datagen" connector and click "PAUSE" or "DELETE".
