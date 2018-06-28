package com.github.xushiyan.kafka.connect.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

import java.time.Instant;
import java.util.*;

public class DatagenTask extends SourceTask {
    private DatagenConnectorConfig config;
    private Gson gson;
    private JsonObject messageTemplate;

    public String version() {
        return VersionUtil.VERSION;
    }

    public void start(Map<String, String> props) {
        this.config = new DatagenConnectorConfig(DatagenConnectorConfig.definition(), props);
        this.gson = new GsonBuilder().create();
        this.messageTemplate = this.gson.fromJson(this.config.messageTemplate, JsonObject.class);
    }

    private final Map<String, ?> sourcePartition = new HashMap<>();
    private final Map<String, ?> sourceOffset = new HashMap<>();

    public List<SourceRecord> poll() throws InterruptedException {
        DatagenConnectorConfig config = this.config;
        Gson gson = this.gson;
        JsonObject msgTemplate = this.messageTemplate;

        Thread.sleep((long) (config.batchInterval * 1000));

        List<SourceRecord> records = new ArrayList<>(config.batchSize);
        Random randomizer = new Random();

        for (int i = 0; i < config.batchSize; i++) {
            JsonObject msg = msgTemplate.deepCopy();

            int num = config.randomFieldValues.size();
            String randomValue = config.randomFieldValues.get(randomizer.nextInt(num));
            msg.addProperty(config.randomField, randomValue);

            long now = Instant.now().toEpochMilli();
            msg.addProperty(config.eventTimestampField, now);

            records.add(new SourceRecord(sourcePartition, sourceOffset, config.topic, Schema.STRING_SCHEMA, gson.toJson(msg)));
        }

        return records;
    }

    public void stop() {

    }
}
