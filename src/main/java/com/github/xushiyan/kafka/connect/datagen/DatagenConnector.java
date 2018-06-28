package com.github.xushiyan.kafka.connect.datagen;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatagenConnector extends SourceConnector {
    private Map<String, String> props;

    public String version() {
        return VersionUtil.VERSION;
    }

    public void start(Map<String, String> props) {
        this.props = props;
    }

    public Class<? extends Task> taskClass() {
        return DatagenTask.class;
    }

    public List<Map<String, String>> taskConfigs(int maxTasks) {
        List<Map<String, String>> configs = new ArrayList<>();
        for (int i = 0; i < maxTasks; i++) {
            configs.add(this.props);
        }
        return configs;
    }

    public void stop() {

    }

    public ConfigDef config() {
        return DatagenConnectorConfig.definition();
    }
}
