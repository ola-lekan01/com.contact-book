package org.contact.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

public class ContactRequest {
    private String firstName;
    private String lastName;
    private Set<String> phoneNumber = new HashSet<>();
    private String email;
    private String address;
    private LocalDate date;
}
