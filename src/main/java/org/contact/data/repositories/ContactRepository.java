package org.contact.data.repositories;

import org.contact.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, Integer> {

}
