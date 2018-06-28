package com.github.xushiyan.kafka.connect.datagen;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;

import java.util.List;
import java.util.Map;

public class DatagenConnectorConfig extends AbstractConfig {
    public static final String TOPIC_CONFIG = "topic";
    private static final String TOPIC_DOC = "Kafka Topic to write to.";

    public static final String MESSAGE_COUNT_CONFIG = "message.count";
    private static final String MESSAGE_COUNT_DOC = "Number of messages to be sent.";

    public static final String MESSAGE_TEMPLATE_CONFIG = "message.template";
    private static final String MESSAGE_TEMPLATE_DOC = "Template to be used for each message.";

    public static final String RANDOM_FIELD_CONFIG = "random.field";
    private static final String RANDOM_FIELD_DOC = "Field to be randomized.";

    public static final String RANDOM_FIELD_VALUES_CONFIG = "random.field.values";
    private static final String RANDOM_FIELD_VALUES_DOC = "Possible values for the specified random field.";

    public static final String EVENT_TIMESTAMP_FIELD_CONFIG = "event.timestamp.field";
    private static final String EVENT_TIMESTAMP_FIELD_DOC = "Field for storing event timestamp.";

    public final String topic;
    public final int messageCount;
    public final String messageTemplate;
    public final String randomField;
    public final List<String> randomFieldValues;
    public final String eventTimestampField;

    public DatagenConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
        this.topic = getString(TOPIC_CONFIG);
        this.messageCount = getInt(MESSAGE_COUNT_CONFIG);
        this.messageTemplate = getString(MESSAGE_TEMPLATE_CONFIG);
        this.randomField = getString(RANDOM_FIELD_CONFIG);
        this.randomFieldValues = getList(RANDOM_FIELD_VALUES_CONFIG);
        this.eventTimestampField = getString(EVENT_TIMESTAMP_FIELD_CONFIG);
    }

    private static final ConfigDef CONFIG_DEF = new ConfigDef()
            .define(TOPIC_CONFIG, Type.STRING, Importance.HIGH, TOPIC_DOC)
            .define(MESSAGE_COUNT_CONFIG, Type.INT, Importance.HIGH, MESSAGE_COUNT_DOC)
            .define(MESSAGE_TEMPLATE_CONFIG, Type.STRING, Importance.HIGH, MESSAGE_TEMPLATE_DOC)
            .define(RANDOM_FIELD_CONFIG, Type.STRING, Importance.HIGH, RANDOM_FIELD_DOC)
            .define(RANDOM_FIELD_VALUES_CONFIG, Type.LIST, Importance.HIGH, RANDOM_FIELD_VALUES_DOC)
            .define(EVENT_TIMESTAMP_FIELD_CONFIG, Type.STRING, "ts", Importance.MEDIUM, EVENT_TIMESTAMP_FIELD_DOC);

    public static ConfigDef definition() {
        return CONFIG_DEF;
    }
}
