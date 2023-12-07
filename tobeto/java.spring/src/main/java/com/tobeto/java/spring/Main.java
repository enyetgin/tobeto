package com.tobeto.java.spring;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Enes");
        customer1.setLastName("Yetgin");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Ahmet");
        customer2.setLastName("Erincik");
        customers.add(customer2);

        //Lambda Expression
        customers.forEach((item)->{
            System.out.println(item.getFirstName());
        });

        List<GetListCustomerResponse> result =
                customers
                .stream()
                .map((customer) -> new GetListCustomerResponse(customer.getFirstName(), customer.getLastName())).toList();

        System.out.println("*********Filter*********");
        List<Customer> filterCustomers = customers.stream().filter((customer) -> customer.getFirstName().length() > 4).toList();
        System.out.println(filterCustomers.size());

        List<Customer> filteredCustomers2 = customers.stream().filter((customer) -> {
            int minLength = 2;
            return customer.getFirstName().length() > minLength && customer.getLastName().equals("Yetgin");
        }).toList();
        System.out.println(filteredCustomers2.size());
        
        System.out.println("*********Compare*********");
        //old compare
        List<Customer> sortedCustomers = customers.stream().sorted((c1, c2) -> c1.getFirstName().compareTo(c2.getFirstName())).toList();
        sortedCustomers.forEach((customer) -> System.out.println(customer.getFirstName()));

        //new compare
        List<Customer> sortedCustomer2 = customers.stream().sorted(Comparator.comparing(Customer::getFirstName).thenComparing(Customer::getLastName)).toList();
        sortedCustomer2.forEach((customer) -> System.out.println(customer.getFirstName()));
    }
}
