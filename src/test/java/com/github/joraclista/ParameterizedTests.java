package com.github.joraclista;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Iterator;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Alisa
 * version 1.0.
 */
@RunWith(JUnitPlatform.class)
@Slf4j
public class ParameterizedTests {


    @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1, 1, 2",
            "2, 2, 4",
            "3, 5, 8"
    })
    void testAddition(int a, int b, int sum) {
        assertEquals(a + b, sum);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "3" })
    void testIds(String id) {
        assertNotNull(id);
    }

    enum DAY {MON, TUE, WED}

    @ParameterizedTest
    @EnumSource(DAY.class)
    void testValidIds(DAY day) {
        assertNotNull(day);
    }

    static Iterator<Integer> idsProvider() {
        return IntStream.of(1, 2, 3, 4).iterator();
    }

    @ParameterizedTest
    @MethodSource(value = "idsProvider")
    public void testIds(Integer ids) {
        assertNotNull(ids);
    }
}
