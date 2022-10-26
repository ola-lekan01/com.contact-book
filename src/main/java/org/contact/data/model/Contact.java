package org.contact.data.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private final Set<String> phoneNumber = new HashSet<>();
    private String email;
    private String address;
    private LocalDate date;

}
