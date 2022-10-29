package org.contact.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateContactRequest {
    private String firstName;
    private String lastName;
    private Set<String> phoneNumber = new HashSet<>();
    private String email;
    private String address;
    private LocalDate dateOfBirth;
}
