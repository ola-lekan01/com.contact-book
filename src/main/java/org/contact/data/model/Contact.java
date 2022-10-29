package org.contact.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Document

public class Contact {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Set<String> phoneNumber = new HashSet<>();
    private String email;
    private String address;
    private LocalDate date;

}
