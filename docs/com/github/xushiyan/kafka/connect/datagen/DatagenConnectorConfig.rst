.. java:import:: org.apache.kafka.common.config AbstractConfig

.. java:import:: org.apache.kafka.common.config ConfigDef

.. java:import:: org.apache.kafka.common.config ConfigDef.Importance

.. java:import:: org.apache.kafka.common.config ConfigDef.Type

.. java:import:: java.util List

.. java:import:: java.util Map

DatagenConnectorConfig
======================

.. java:package:: com.github.xushiyan.kafka.connect.datagen
   :noindex:

.. java:type:: public class DatagenConnectorConfig extends AbstractConfig

Fields
------
eventTimestampField
^^^^^^^^^^^^^^^^^^^

.. java:field:: public final String eventTimestampField
   :outertype: DatagenConnectorConfig

messageTemplate
^^^^^^^^^^^^^^^

.. java:field:: public final String messageTemplate
   :outertype: DatagenConnectorConfig

pollInterval
^^^^^^^^^^^^

.. java:field:: public final int pollInterval
   :outertype: DatagenConnectorConfig

pollSize
^^^^^^^^

.. java:field:: public final int pollSize
   :outertype: DatagenConnectorConfig

randomFields
^^^^^^^^^^^^

.. java:field:: public final List<String> randomFields
   :outertype: DatagenConnectorConfig

testMode
^^^^^^^^

.. java:field:: public final String testMode
   :outertype: DatagenConnectorConfig

topic
^^^^^

.. java:field:: public final String topic
   :outertype: DatagenConnectorConfig

Constructors
------------
DatagenConnectorConfig
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DatagenConnectorConfig(ConfigDef definition, Map<?, ?> originals)
   :outertype: DatagenConnectorConfig

Methods
-------
definition
^^^^^^^^^^

.. java:method:: public static ConfigDef definition()
   :outertype: DatagenConnectorConfig

   :return: The \ :java:ref:`ConfigDef`\  of \ :java:ref:`DatagenConnector`\ .

