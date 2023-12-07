package com.tobeto.java.spring.services.abstracts;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.java.spring.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void delete(int id);
    void update(int id, UpdateCustomerRequest request);

    List<Customer> getByFirstname(String name);
    List<GetListCustomerResponse> getByFirstNameDto(String name);

    Customer getById(int id);


}
