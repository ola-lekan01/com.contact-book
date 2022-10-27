package org.contact.data.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
@Builder
public class Contact {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private Set<String> phoneNumber = new HashSet<>();
    private String email;
    private String address;
    private LocalDate date;

}
