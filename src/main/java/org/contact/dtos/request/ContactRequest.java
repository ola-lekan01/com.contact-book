package org.contact.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class ContactRequest {
    private int id;
private String firstName;
private final Set<String> phoneNumber = new HashSet<>();

}
