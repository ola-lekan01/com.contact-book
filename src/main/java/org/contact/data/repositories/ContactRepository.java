package org.contact.data.repositories;

import org.contact.data.model.Contact;

public interface ContactRepository {

void save(Contact contact);
void findByName(String name);
void findByNumber(String phoneNumber);
void findAll();
void update(Contact contact);
void delete(Contact contact);
void deleteAll(Contact contact);
}
