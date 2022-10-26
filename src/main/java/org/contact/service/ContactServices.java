package org.contact.service;

import org.contact.data.model.Contact;

public interface ContactServices {
    void saveContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(Contact contact);
    void findContactByName(String name);
    void findContactByNumber(String phoneNumber);
    void deleteAllContact();
}
