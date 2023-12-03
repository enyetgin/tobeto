package com.tobeto.java.spring.services.dtos.requests.employee;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {
    private String firstName;
    private String lastName;
    private String position;
    private String eMail;
    private String phoneNumber;
}
