package com.github.joraclista;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by Alisa
 * version 1.0.
 */
@DisplayName("Display Name Test Case")
public class DisplayNameTest {

    @Test
    @DisplayName("Testing that with @DisplayName annotation you can specify custom test name")
    void testDisplayNamePresent() {
    }

    @Test
    void testDisplayNameNotPresent() {
    }

}
