package org.contact.service;

import org.contact.data.model.Contact;
import org.contact.dtos.request.ContactRequest;
import org.contact.dtos.response.ContactResponse;
import java.util.List;
import java.util.Optional;

public interface ContactService {
    ContactResponse saveContact(ContactRequest request);
    Contact updateContact(Contact contact);
    Optional<List<Contact>> findContactByName(String name);
    Optional<List<Contact>> findContactByNumber(String phoneNumber);
    void deleteContact(Contact contact);
    void deleteAllContact();
}
