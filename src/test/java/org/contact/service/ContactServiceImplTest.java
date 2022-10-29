package org.contact.service;

import org.contact.Main;
import org.contact.dtos.request.ContactRequest;
import org.contact.dtos.response.ContactResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {Main.class})
class ContactServiceImplTest {
    @Autowired
    private ContactService contactService;
    private ContactRequest request;

    @BeforeEach
    void setUp() {
        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("08069580949");
        phoneNumbers.add("07041662759");
        phoneNumbers.add("08023325065");
        phoneNumbers.add("08032354010");

        request = ContactRequest.builder()
                .firstName("Lakes")
                .phoneNumber(phoneNumbers)
                .build();
    }

    @Test
    void saveContact() {
        ContactResponse response = contactService.saveContact(request);
        assertNotNull(response);
        assertEquals("201", response.getStatusCode());
    }

    @Test
    void updateContact() {

    }

    @Test
    void findContactByName() {
    }

    @Test
    void findContactByNumber() {
    }

    @Test
    void deleteContact() {
    }

    @Test
    void deleteAllContact() {
    }
}