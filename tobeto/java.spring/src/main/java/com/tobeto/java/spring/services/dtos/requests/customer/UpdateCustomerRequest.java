package com.tobeto.java.spring.services.dtos.requests.customer;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private String firstName;
    private String lastName;
    private String eMail;
    private String phoneNumber;
    private String address;
}
