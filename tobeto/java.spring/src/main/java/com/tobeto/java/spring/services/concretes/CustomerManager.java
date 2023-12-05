package com.tobeto.java.spring.services.concretes;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.repositories.CustomerRepository;
import com.tobeto.java.spring.services.abstracts.CustomerService;
import com.tobeto.java.spring.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.java.spring.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEMail(request.getEMail());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setAddress(request.getAddress());
        customerRepository.save(customer);
    }

    public void delete(int id){
        Customer deleteToCustomer = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(deleteToCustomer);
    }

    @Override
    public void update(int id, UpdateCustomerRequest request){
        Customer updateToCustomer = customerRepository.findById(id).orElseThrow();
        updateToCustomer.setFirstName(request.getFirstName());
        updateToCustomer.setLastName(request.getLastName());
        updateToCustomer.setEMail(request.getEMail());
        updateToCustomer.setPhoneNumber(request.getPhoneNumber());
        updateToCustomer.setAddress(request.getAddress());
        customerRepository.save(updateToCustomer);
    }

    @Override
    public List<Customer> getByFirstname(String name) {
        return customerRepository.findByFirstNameStartingWith(name);
    }

    @Override
    public List<GetListCustomerResponse> getByFirstNameDto(String name) {
        return customerRepository.findByFirstName(name)
                .stream()
                .map((Customer) -> new GetListCustomerResponse(Customer.getFirstName(), Customer.getLastName()))
                .toList();
    }


}
