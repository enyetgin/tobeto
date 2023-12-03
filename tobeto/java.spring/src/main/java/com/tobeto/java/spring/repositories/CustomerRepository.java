package com.tobeto.java.spring.repositories;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstNameStartingWith(String name);
    @Query("SELECT new com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse(c.firstName, c.lastName)"+
            "FROM Customer c WHERE c.firstName = :name")
    List<GetListCustomerResponse> findByFirstName(String name);

}
