package com.tobeto.java.spring.controllers;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.services.abstracts.CustomerService;
import com.tobeto.java.spring.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.java.spring.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/customers")
public class CustomerController {
    //Bağımlılıklar Daima Soyut Classlar üzerinden
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request){
        customerService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        customerService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateCustomerRequest request){
        customerService.update(id, request);
    }

    @GetMapping
    public List<Customer> getByName(@RequestParam String name){
        return customerService.getByFirstname(name);
    }

    @GetMapping("dto")
    public List<GetListCustomerResponse> getByNameDto(@RequestParam String name){
        return customerService.getByFirstNameDto(name);
    }
}
