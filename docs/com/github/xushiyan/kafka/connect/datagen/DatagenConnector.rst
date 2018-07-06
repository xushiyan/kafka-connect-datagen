.. java:import:: com.github.xushiyan.kafka.connect.datagen.utils Version

.. java:import:: org.apache.kafka.common.config ConfigDef

.. java:import:: org.apache.kafka.connect.connector Task

.. java:import:: org.apache.kafka.connect.source SourceConnector

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map

DatagenConnector
================

.. java:package:: com.github.xushiyan.kafka.connect.datagen
   :noindex:

.. java:type:: public class DatagenConnector extends SourceConnector

Methods
-------
config
^^^^^^

.. java:method:: public ConfigDef config()
   :outertype: DatagenConnector

start
^^^^^

.. java:method:: public void start(Map<String, String> props)
   :outertype: DatagenConnector

stop
^^^^

.. java:method:: public void stop()
   :outertype: DatagenConnector

taskClass
^^^^^^^^^

.. java:method:: public Class<? extends Task> taskClass()
   :outertype: DatagenConnector

taskConfigs
^^^^^^^^^^^

.. java:method:: public List<Map<String, String>> taskConfigs(int maxTasks)
   :outertype: DatagenConnector

version
^^^^^^^

.. java:method:: public String version()
   :outertype: DatagenConnector

