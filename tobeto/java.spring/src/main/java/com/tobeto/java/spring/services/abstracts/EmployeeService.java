package com.tobeto.java.spring.services.abstracts;

import com.tobeto.java.spring.entities.Employee;
import com.tobeto.java.spring.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.java.spring.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse;
import com.tobeto.java.spring.services.dtos.responses.employee.GetListEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    void add(AddEmployeeRequest request);
    void delete(int id);
    void update(int id, UpdateEmployeeRequest request);

    List<Employee> getByLastName(String lastName);

    List<GetListEmployeeResponse> getByLastNameAndPositionDto(String lastName, String position);

}
