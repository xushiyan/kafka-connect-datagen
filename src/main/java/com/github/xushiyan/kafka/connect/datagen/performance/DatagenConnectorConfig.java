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

package com.github.xushiyan.kafka.connect.datagen.performance;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

import java.util.List;
import java.util.Map;

public class DatagenConnectorConfig extends AbstractConfig {
    private static final String CONNECTOR_GROUP = "Connector";

    private static final String TOPIC_NAME_CONFIG = "topic.name";
    private static final String TOPIC_NAME_DOC = "Name of the Kafka topic to publish data to.";
    private static final String TOPIC_NAME_DISPLAY = "Topic Name";

    private static final String TEST_MODE_CONFIG = "test.mode";
    private static final String TEST_MODE_DOC = "Indicate test mode: either 'performance' or integration'";
    private static final String TEST_MODE_DISPLAY = "Test Mode";
    private static final String TEST_MODE_DEFAULT = "performance";

    private static final String POLL_SIZE_CONFIG = "poll.size";
    private static final String POLL_SIZE_DOC = "Number of messages to be sent in one poll.";
    private static final String POLL_SIZE_DISPLAY = "Poll Size";
    private static final int POLL_SIZE_DEFAULT = 1;

    private static final String POLL_INTERVAL_CONFIG = "poll.interval.ms";
    private static final String POLL_INTERVAL_DOC = "Time interval (ms) between two polls.";
    private static final String POLL_INTERVAL_DISPLAY = "Poll Interval";
    private static final int POLL_INTERVAL_DEFAULT = 10000;

    private static final String MESSAGE_TEMPLATE_CONFIG = "message.template";
    private static final String MESSAGE_TEMPLATE_DOC = "Message template to be used for each message.";
    private static final String MESSAGE_TEMPLATE_DISPLAY = "Message Template";

    private static final String RANDOM_FIELDS_CONFIG = "random.fields";
    private static final String RANDOM_FIELDS_DOC = "List of fields to be randomized.";
    private static final String RANDOM_FIELDS_DISPLAY = "Random Fields";

    private static final String EVENT_TIMESTAMP_FIELD_CONFIG = "event.timestamp.field";
    private static final String EVENT_TIMESTAMP_FIELD_DOC = "Name of the field to store event timestamp.";
    private static final String EVENT_TIMESTAMP_FIELD_DISPLAY = "Event timestamp's field name";
    private static final String EVENT_TIMESTAMP_FIELD_DEFAULT = "ts";

    private static final ConfigDef CONFIG_DEF = new ConfigDef()
            .define(TOPIC_NAME_CONFIG,
                    Type.STRING,
                    Importance.HIGH,
                    TOPIC_NAME_DOC,
                    CONNECTOR_GROUP, 1,
                    ConfigDef.Width.LONG,
                    TOPIC_NAME_DISPLAY)
            .define(TEST_MODE_CONFIG,
                    Type.STRING,
                    TEST_MODE_DEFAULT,
                    Importance.HIGH,
                    TEST_MODE_DOC,
                    CONNECTOR_GROUP, 2,
                    ConfigDef.Width.LONG,
                    TEST_MODE_DISPLAY)
            .define(POLL_SIZE_CONFIG,
                    Type.INT,
                    POLL_SIZE_DEFAULT,
                    Importance.MEDIUM,
                    POLL_SIZE_DOC,
                    CONNECTOR_GROUP, 3,
                    ConfigDef.Width.LONG,
                    POLL_SIZE_DISPLAY)
            .define(POLL_INTERVAL_CONFIG,
                    Type.INT,
                    POLL_INTERVAL_DEFAULT,
                    Importance.MEDIUM,
                    POLL_INTERVAL_DOC,
                    CONNECTOR_GROUP, 4,
                    ConfigDef.Width.LONG,
                    POLL_INTERVAL_DISPLAY)
            .define(MESSAGE_TEMPLATE_CONFIG,
                    Type.STRING,
                    Importance.MEDIUM,
                    MESSAGE_TEMPLATE_DOC,
                    CONNECTOR_GROUP, 5,
                    ConfigDef.Width.LONG,
                    MESSAGE_TEMPLATE_DISPLAY)
            .define(RANDOM_FIELDS_CONFIG,
                    Type.LIST,
                    Importance.MEDIUM,
                    RANDOM_FIELDS_DOC,
                    CONNECTOR_GROUP, 6,
                    ConfigDef.Width.LONG,
                    RANDOM_FIELDS_DISPLAY)
            .define(EVENT_TIMESTAMP_FIELD_CONFIG,
                    Type.STRING,
                    EVENT_TIMESTAMP_FIELD_DEFAULT,
                    Importance.LOW,
                    EVENT_TIMESTAMP_FIELD_DOC,
                    CONNECTOR_GROUP, 7,
                    ConfigDef.Width.LONG,
                    EVENT_TIMESTAMP_FIELD_DISPLAY);

    public final String topicName;
    public final String testMode;
    public final int pollSize;
    public final int pollInterval;
    public final String messageTemplate;
    public final List<String> randomFields;
    public final String eventTimestampField;

    public DatagenConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
        this.topicName = getString(TOPIC_NAME_CONFIG);
        this.testMode = getString(TEST_MODE_CONFIG);
        this.pollSize = getInt(POLL_SIZE_CONFIG);
        this.pollInterval = getInt(POLL_INTERVAL_CONFIG);
        this.messageTemplate = getString(MESSAGE_TEMPLATE_CONFIG);
        this.randomFields = getList(RANDOM_FIELDS_CONFIG);
        this.eventTimestampField = getString(EVENT_TIMESTAMP_FIELD_CONFIG);
    }

    /**
     * @return The {@link ConfigDef} of {@link DatagenConnector}.
     */
    public static ConfigDef definition() {
        return CONFIG_DEF;
    }

}
