package org.contact.data.repositories;

import org.contact.data.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{

    private final List<ContactRepository> contactRepositories = new ArrayList<>();

    @Override
    public void save(Contact contact) {

    }

    @Override
    public void findByName(String name) {

    }

    @Override
    public void findByNumber(String phoneNumber) {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public void deleteAll(Contact contact) {

    }
}
