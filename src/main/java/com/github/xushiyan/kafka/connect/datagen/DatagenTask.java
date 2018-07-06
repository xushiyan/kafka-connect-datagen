/*
 *  Copyright © 2018 Xu Shiyan (xu.shiyan.raymond@gmail.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.github.xushiyan.kafka.connect.datagen;

import com.github.xushiyan.kafka.connect.datagen.utils.Version;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class DatagenTask extends SourceTask {
    private DatagenConnectorConfig config;
    private Gson gson;
    private JsonObject messageTemplate;

    public String version() {
        return Version.get();
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

        Thread.sleep(config.pollInterval);

        List<SourceRecord> records = new ArrayList<>(config.pollSize);
        Random randomizer = new Random();

        List<String> randomFieldsValues = config.randomFields;
        Map<String, String[]> randomFieldsValueMap = new HashMap<>();
        for (String kv : randomFieldsValues) {
            String[] fieldAndValues = kv.split(":");
            String fieldName = fieldAndValues[0];
            String[] values = fieldAndValues[1].split(Pattern.quote("|"));
            randomFieldsValueMap.put(fieldName, values);
        }

        for (int i = 0; i < config.pollSize; i++) {
            JsonObject msg = msgTemplate.deepCopy();

            for (Map.Entry<String, String[]> entry : randomFieldsValueMap.entrySet()) {
                String[] values = entry.getValue();
                msg.addProperty(entry.getKey(), values[randomizer.nextInt(values.length)]);
            }

            Instant now = Instant.now();
            long nanos = TimeUnit.SECONDS.toNanos(now.getEpochSecond()) + now.getNano();

            msg.addProperty(config.eventTimestampField, nanos);

            records.add(new SourceRecord(sourcePartition, sourceOffset, config.topic, Schema.STRING_SCHEMA, gson.toJson(msg)));
        }

        return records;
    }

    public void stop() {

    }
}
