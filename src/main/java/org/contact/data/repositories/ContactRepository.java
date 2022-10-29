package org.contact.data.repositories;

import org.contact.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.Set;

public interface ContactRepository extends MongoRepository<Contact, String> {
    Optional<Contact>findByFirstNameEqualsIgnoreCase(String firstName);
//    Optional<Contact>findContactByFirstNameEqualsIgnoreCaseOrLastNameEqualsIgnoreCase(String firstName, String lastName);
    Optional<Contact>findContactByPhoneNumber(Set<String> phoneNumber);
}
