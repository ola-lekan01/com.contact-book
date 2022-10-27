package org.contact.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

public class ContactRequest {
private String firstName;
@Id
private int id;
private Set<String> phoneNumber = new HashSet<>();

}
