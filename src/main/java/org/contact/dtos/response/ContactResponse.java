package org.contact.dtos.response;

import lombok.Data;

@Data
public class ContactResponse {
    private String statusCode;
    private String message;
    private String id;
}
