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

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

import java.util.List;
import java.util.Map;

public class DatagenConnectorConfig extends AbstractConfig {

    private static final String TOPIC_CONFIG = "topic";

    private static final String TEST_MODE_CONFIG = "test.mode";

    private static final String POLL_SIZE_CONFIG = "poll.size";

    private static final String POLL_INTERVAL_CONFIG = "poll.interval.ms";

    private static final String MESSAGE_TEMPLATE_CONFIG = "message.template";

    private static final String RANDOM_FIELD_CONFIG = "random.field";

    private static final String RANDOM_FIELD_VALUES_CONFIG = "random.field.values";

    private static final String EVENT_TIMESTAMP_FIELD_CONFIG = "event.timestamp.field";

    private static final ConfigDef CONFIG_DEF = new ConfigDef()
            .define(TOPIC_CONFIG, Type.STRING, Importance.HIGH, "Kafka topic")
            .define(TEST_MODE_CONFIG, Type.STRING, "performance", Importance.HIGH, "Test mode: either 'performance' or integration'")
            .define(POLL_SIZE_CONFIG, Type.INT, Importance.HIGH, "Number of messages sent in 1 batch")
            .define(POLL_INTERVAL_CONFIG, Type.INT, Importance.HIGH, "Time interval in seconds between 2 batches.")
            .define(MESSAGE_TEMPLATE_CONFIG, Type.STRING, Importance.HIGH, "Template to be used for each message.")
            .define(RANDOM_FIELD_CONFIG, Type.STRING, Importance.HIGH, "Field to be randomized.")
            .define(RANDOM_FIELD_VALUES_CONFIG, Type.LIST, Importance.HIGH, "Possible values for the specified random field.")
            .define(EVENT_TIMESTAMP_FIELD_CONFIG, Type.STRING, "ts", Importance.MEDIUM, "Field for storing event timestamp.");

    public final String topic;
    public final String testMode;
    public final int pollSize;
    public final int pollInterval;
    public final String messageTemplate;
    public final String randomField;
    public final List<String> randomFieldValues;
    public final String eventTimestampField;

    public DatagenConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
        this.topic = getString(TOPIC_CONFIG);
        this.testMode = getString(TEST_MODE_CONFIG);
        this.pollSize = getInt(POLL_SIZE_CONFIG);
        this.pollInterval = getInt(POLL_INTERVAL_CONFIG);
        this.messageTemplate = getString(MESSAGE_TEMPLATE_CONFIG);
        this.randomField = getString(RANDOM_FIELD_CONFIG);
        this.randomFieldValues = getList(RANDOM_FIELD_VALUES_CONFIG);
        this.eventTimestampField = getString(EVENT_TIMESTAMP_FIELD_CONFIG);
    }

    public static ConfigDef definition() {
        return CONFIG_DEF;
    }
}
