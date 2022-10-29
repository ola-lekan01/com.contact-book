package org.contact.service;

import lombok.AllArgsConstructor;
import org.contact.data.model.Contact;
import org.contact.data.repositories.ContactRepository;
import org.contact.dtos.request.ContactRequest;
import org.contact.dtos.response.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactResponse saveContact(ContactRequest request) {

        Contact contact = new Contact();
        contact.setFirstName(request.getFirstName());
        Set<String>phoneNumbers = request.getPhoneNumber();
        contact.setPhoneNumber(phoneNumbers);

        var savedCustomer = contactRepository.save(contact);

        ContactResponse response = new ContactResponse();
        response.setStatusCode("201");
        response.setMessage("User Created Successfully");
        response.setId(savedCustomer.getId());

        return response;
    }



    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }

    @Override
    public Optional<List<Contact>> findContactByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Contact>> findContactByNumber(String phoneNumber) {
        return Optional.empty();
    }

    @Override
    public void deleteContact(Contact contact) {

    }

    @Override
    public void deleteAllContact() {

    }
}
