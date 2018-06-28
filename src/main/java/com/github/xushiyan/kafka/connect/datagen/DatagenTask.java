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
        return "1.0";
    }

    public void start(Map<String, String> props) {
        this.config = new DatagenConnectorConfig(DatagenConnectorConfig.definition(), props);
        this.gson = new GsonBuilder().create();
        this.messageTemplate = this.gson.fromJson(this.config.messageTemplate, JsonObject.class);
    }

    Map<String, ?> sourcePartition = new HashMap<>();
    Map<String, ?> sourceOffset = new HashMap<>();

    public List<SourceRecord> poll() throws InterruptedException {
        List<SourceRecord> records = new ArrayList<>(this.config.messageCount);
        Random randomizer = new Random();

        for (int i = 0; i < this.config.messageCount; i++) {
            JsonObject msg = messageTemplate.deepCopy();

            int size = this.config.randomFieldValues.size();
            String randomValue = this.config.randomFieldValues.get(randomizer.nextInt(size));
            msg.addProperty(this.config.randomField, randomValue);

            long now = Instant.now().toEpochMilli();
            msg.addProperty(this.config.eventTimestampField, now);

            records.add(new SourceRecord(sourcePartition, sourceOffset, this.config.topic, Schema.STRING_SCHEMA, this.gson.toJson(msg)));
        }
        return records;
    }

    public void stop() {

    }
}
