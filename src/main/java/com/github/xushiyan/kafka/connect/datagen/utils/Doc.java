package com.github.xushiyan.kafka.connect.datagen.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.github.xushiyan.kafka.connect.datagen.performance.DatagenConnectorConfig.definition;

public class Doc {
    private static final String CONFIGS_DOC_NAME = "configs_performance_connector.rst";

    public static void main(String[] args) throws IOException {
        Path docPath = Paths.get(args[0], CONFIGS_DOC_NAME);
        try (BufferedWriter writer = Files.newBufferedWriter(docPath)) {
            writer.write(definition().toRst());
        }
    }
}
