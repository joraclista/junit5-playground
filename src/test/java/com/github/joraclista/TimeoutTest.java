package com.github.joraclista;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * Created by Alisa
 * version 1.0.
 */
@RunWith(JUnitPlatform.class)
@Slf4j
public class TimeoutTest {

    @Test
    void testTaskPerformingLessThan() {
        assertTimeout(ofMinutes(1), () -> new Task().performDuring(ofSeconds(55)));
    }

    @Test
    void testTaskPerformingMoreThan() {
        assertTimeout(ofMinutes(1), () -> new Task().performDuring(ofSeconds(65)));
    }
}
