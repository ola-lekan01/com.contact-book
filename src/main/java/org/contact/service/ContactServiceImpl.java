package org.contact.service;

import lombok.AllArgsConstructor;
import org.contact.data.model.Contact;
import org.contact.data.repositories.ContactRepository;
import org.contact.dtos.request.ContactRequest;
import org.contact.dtos.response.ContactResponse;
import org.contact.exceptions.ContactNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactResponse saveContact(ContactRequest request) {
        Contact savedCustomer = createContact(request);
        return ContactResponse.builder()
                .statusCode("201")
                .message("Contact Saved Successfully")
                .id(savedCustomer.getId())
                .build();
    }

    private Contact createContact(ContactRequest request) {
        Contact contact = new Contact();

        contact.setFirstName(request.getFirstName());
        Set<String>phoneNumbers = request.getPhoneNumber();
        contact.setPhoneNumber(phoneNumbers);
        return contactRepository.save(contact);
    }


    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }

    @Override
    public Optional<Contact> findById(String id) {
        return contactRepository.findById(id);
    }

    @Override
    public Optional<Contact> findContactByName(String firstName) {
        return Optional.ofNullable(contactRepository.findByFirstNameEqualsIgnoreCase(firstName).orElseThrow(
                () -> new ContactNotFoundException(String.format("User with %s does not exist", firstName))));
    }

    @Override
    public Optional<Contact> findContactByNumber(String ... phoneNumber) {
        Set<String> paramsPhoneNumber = new HashSet<>();
        return Optional.ofNullable(contactRepository.findContactByPhoneNumber((paramsPhoneNumber)).orElseThrow(
                () -> new ContactNotFoundException(String.format("Contact with Number %s not found", phoneNumber))));
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }


    @Override
    public void deleteAllContact() {
        contactRepository.deleteAll();
    }
}
