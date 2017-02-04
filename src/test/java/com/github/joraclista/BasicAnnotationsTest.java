package com.github.joraclista;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

/**
 * Created by Alisa
 * version 1.0.
 */
@Slf4j
@DisplayName("Testing Before% and After% Annotations")
public class BasicAnnotationsTest {
    @BeforeAll
    static void initAllTests() {
        log.info("initAllTests");
    }

    @BeforeEach
    void initTest() {
        log.info("init Test");
    }

    @Test
    void testSomething() {
    }

    @Test
    void testSomethingElse() {
    }
    /**
     * This will be skipped
     */
    @Test
    @Disabled
    void disabledTest() {
    }

    @AfterEach
    void afterTest() {
        log.info("after Test");
    }

    @AfterAll
    static void afterAll() {
        log.info("after All Tests");
    }
}
