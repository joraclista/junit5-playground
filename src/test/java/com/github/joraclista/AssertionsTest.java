package com.github.joraclista;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Alisa
 * version 1.0.
 */
@RunWith(JUnitPlatform.class)
@Slf4j
public class AssertionsTest {

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
    void testAssertEquals() {
        assertEquals(contact.getName(), "amy");
        assertEquals(contact.getSurname(), "black");
        assertNotEquals(contact.getSurname(), "crazy");
    }

    @Test
    void testAssertEqualsWithMessage() {
        assertEquals(contact.getContacts().size(), 3, "Only 2 contacts should be available");
    }

    @Test
    void testAssertEqualsWithLazyMessageSupplier() {
        assertEquals(contact.getContacts().size(), 3, () -> "Only 2 contacts should be available");
    }

    @Test
    void groupedAssertionsTest() {
        assertAll("contact",
                () -> assertEquals("amy", contact.getName()),
                () -> assertEquals("black", contact.getSurname())
        );
    }

    @Test
    void testAssertTrue() {
        assertTrue(contact.getContacts().size() < 10, () -> "Contacts number should be less than 10");
    }

    @Test
    void testNullAssertions() {
        assertNull(Contact.builder()
                .email("tommy.green@g-mail.com")
                .name("tommy")
                .surname("green")
                .build().getContacts());
        assertNotNull(contact.getSurname());

    }

    @Test
    void testSameAssertions() {
        assertSame("amy", "amy");
        String tommyEmail = "tommy.green@g-mail.com";
        assertNotSame(Contact.builder()
                        .email(tommyEmail)
                        .build(),
                Contact.builder()
                        .email(tommyEmail)
                        .build());
    }
}
