package com.tobeto.java.spring.services.dtos.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListEmployeeResponse {
    private String lastName;
    private String position;
}
