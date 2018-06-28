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

    private static final String BATCH_SIZE_CONFIG = "batch.size";

    private static final String BATCH_INTERVAL_CONFIG = "batch.interval";

    private static final String MESSAGE_TEMPLATE_CONFIG = "message.template";

    private static final String RANDOM_FIELD_CONFIG = "random.field";

    private static final String RANDOM_FIELD_VALUES_CONFIG = "random.field.values";

    private static final String EVENT_TIMESTAMP_FIELD_CONFIG = "event.timestamp.field";

    private static final ConfigDef CONFIG_DEF = new ConfigDef()
            .define(TOPIC_CONFIG, Type.STRING, Importance.HIGH, "Kafka topic")
            .define(TEST_MODE_CONFIG, Type.STRING, "performance", Importance.HIGH, "Test mode: either 'performance' or integration'")
            .define(BATCH_SIZE_CONFIG, Type.INT, Importance.HIGH, "Number of messages sent in 1 batch")
            .define(BATCH_INTERVAL_CONFIG, Type.DOUBLE, Importance.HIGH, "Time interval in seconds between 2 batches.")
            .define(MESSAGE_TEMPLATE_CONFIG, Type.STRING, Importance.HIGH, "Template to be used for each message.")
            .define(RANDOM_FIELD_CONFIG, Type.STRING, Importance.HIGH, "Field to be randomized.")
            .define(RANDOM_FIELD_VALUES_CONFIG, Type.LIST, Importance.HIGH, "Possible values for the specified random field.")
            .define(EVENT_TIMESTAMP_FIELD_CONFIG, Type.STRING, "ts", Importance.MEDIUM, "Field for storing event timestamp.");

    public final String topic;
    public final String testMode;
    public final int batchSize;
    public final double batchInterval;
    public final String messageTemplate;
    public final String randomField;
    public final List<String> randomFieldValues;
    public final String eventTimestampField;

    public DatagenConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
        this.topic = getString(TOPIC_CONFIG);
        this.testMode = getString(TEST_MODE_CONFIG);
        this.batchSize = getInt(BATCH_SIZE_CONFIG);
        this.batchInterval = getDouble(BATCH_INTERVAL_CONFIG);
        this.messageTemplate = getString(MESSAGE_TEMPLATE_CONFIG);
        this.randomField = getString(RANDOM_FIELD_CONFIG);
        this.randomFieldValues = getList(RANDOM_FIELD_VALUES_CONFIG);
        this.eventTimestampField = getString(EVENT_TIMESTAMP_FIELD_CONFIG);
    }

    public static ConfigDef definition() {
        return CONFIG_DEF;
    }
}
