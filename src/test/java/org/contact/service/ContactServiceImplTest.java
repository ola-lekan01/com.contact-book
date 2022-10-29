package org.contact.service;

import org.contact.Main;
import org.contact.dtos.request.ContactRequest;
import org.contact.dtos.request.UpdateContactRequest;
import org.contact.dtos.response.ContactResponse;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {Main.class})
class ContactServiceImplTest {
    @Autowired
    private ContactService contactService;
    private ContactRequest request;
    private ContactRequest request1;
    private UpdateContactRequest updateRequest;

    @BeforeEach
    void setUp() {
        Set<String> phoneNumbers = new HashSet<>();
        phoneNumbers.add("08069580949");
        phoneNumbers.add("07041662759");

        request = ContactRequest.builder()
                .firstName("lakes")
                .phoneNumber(phoneNumbers)
                .build();


        Set<String> phoneNumbers1 = new HashSet<>();
        phoneNumbers.add("08023325065");
        phoneNumbers.add("08032354010");

        request1 = ContactRequest.builder()
                .firstName("Jojo")
                .lastName("Kore")
                .address("Festac Town")
                .phoneNumber(phoneNumbers1)
                .build();

        updateRequest = new UpdateContactRequest();
    }

    @AfterEach
    void tearDown() {
        contactService.deleteAllContact();
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
    void findContactById(){
        var savedContact  = contactService.saveContact(request);
        var foundContact = contactService.findById(savedContact.getId());
        assertThat(foundContact.get().getId()).isEqualTo(savedContact.getId());
    }

    @Test
    void findContactByName() {
        var saved  = contactService.saveContact(request1);
        var found = contactService.findContactByName("jojo");
        var foundContact = contactService.findById(saved.getId());
        assertThat(foundContact.get().getFirstName()).isEqualTo(found.get().getFirstName());
    }

    @Test
    void findContactByNumber() {
        var savedContact = contactService.saveContact(request1);
        var foundContact = contactService.findById(savedContact.getId());
        var findContact = contactService.findContactByNumber("08032354010");
        assertThat(foundContact.get().getPhoneNumber()).isEqualTo(findContact.get().getPhoneNumber()
        );
    }

    @Test
    void deleteContact() {
        var saved  = contactService.saveContact(request1);
        var found = contactService.findContactByName("jojo");
        contactService.deleteContact(found.get());
        var foundContact = contactService.findById(saved.getId());
        assertThat(foundContact.isEmpty()).isTrue();

    }

    @Test
    void deleteAllContact() {
        var savedContact  = contactService.saveContact(request1);
        var savedContact1  = contactService.saveContact(request);
        contactService.deleteAllContact();

        var foundContact1 = contactService.findById(savedContact1.getId());
        var foundContact = contactService.findById(savedContact.getId());
        assertThat(foundContact.isEmpty()).isTrue();
        assertThat(foundContact1.isEmpty()).isTrue();


    }
}