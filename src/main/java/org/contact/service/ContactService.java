package org.contact.service;

import org.contact.data.model.Contact;
import org.contact.dtos.request.ContactRequest;
import org.contact.dtos.response.ContactResponse;

import java.util.Optional;

public interface ContactService {
    ContactResponse saveContact(ContactRequest request);
    Contact updateContact(Contact contact);
    Optional<Contact> findById(String id);
    Optional<Contact> findContactByName(String firstName);
    Optional<Contact> findContactByNumber(String... phoneNumber);
    void deleteContact(Contact contact);
    void deleteAllContact();
}
