package com.github.joraclista;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Alisa
 * version 1.0.
 */
@RunWith(JUnitPlatform.class)
@Slf4j
public class ExceptionsTest {

    private static Contact contact;

    @BeforeEach
    void initTest() {
        contact = Contact.builder()
                .email("amy.black@g-mail.com")
                .name("amy")
                .surname("black")
                .contacts(asList(
                        Contact.builder()
                                .email("johny.white@g-mail.com")
                                .name("johny")
                                .surname("white")
                                .build(),
                        Contact.builder()
                                .email("tommy.green@g-mail.com")
                                .name("tommy")
                                .surname("green")
                                .build()))
                .build();
    }

    @Test
    void testException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> contact.greet(Contact.builder()
                .email("tim.orange@g-mail.com")
                .name("tim")
                .surname("orange")
                .build()));
        assertEquals("not supported", exception.getMessage());
    }

}
