.. java:import:: com.github.xushiyan.kafka.connect.datagen.utils Version

.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson GsonBuilder

.. java:import:: com.google.gson JsonObject

.. java:import:: org.apache.kafka.connect.data Schema

.. java:import:: org.apache.kafka.connect.source SourceRecord

.. java:import:: org.apache.kafka.connect.source SourceTask

.. java:import:: java.time Instant

.. java:import:: java.util.concurrent TimeUnit

.. java:import:: java.util.regex Pattern

DatagenTask
===========

.. java:package:: com.github.xushiyan.kafka.connect.datagen
   :noindex:

.. java:type:: public class DatagenTask extends SourceTask

Methods
-------
poll
^^^^

.. java:method:: public List<SourceRecord> poll() throws InterruptedException
   :outertype: DatagenTask

start
^^^^^

.. java:method:: public void start(Map<String, String> props)
   :outertype: DatagenTask

stop
^^^^

.. java:method:: public void stop()
   :outertype: DatagenTask

version
^^^^^^^

.. java:method:: public String version()
   :outertype: DatagenTask

