package com.tobeto.java.spring.controllers;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Service
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable int id,@RequestBody Customer updatedCustomer) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
        customerToUpdate.setFirstName(updatedCustomer.getFirstName());
        customerToUpdate.setLastName(updatedCustomer.getLastName());
        customerToUpdate.setEMail(updatedCustomer.getEMail());
        customerToUpdate.setPhoneNumber(updatedCustomer.getPhoneNumber());
        customerToUpdate.setAddress(updatedCustomer.getAddress());

        Customer customer1 = customerRepository.save(customerToUpdate);
    }


}
