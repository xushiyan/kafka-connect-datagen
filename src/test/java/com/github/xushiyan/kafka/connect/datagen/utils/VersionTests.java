package com.github.xushiyan.kafka.connect.datagen.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.junit.MatcherAssert.assertThat;

class VersionTests {
    @Test
    void testVersionStringFormat() {
        assertThat(Version.get(), matchesPattern("^\\d+\\.\\d+\\.\\d+[\\.\\-]?[A-Z]*$"));
    }
}
