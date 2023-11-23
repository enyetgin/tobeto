package com.tobeto.java.spring.controllers;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.entities.Employee;
import com.tobeto.java.spring.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id){
        return employeeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employeeToDelete);
    }

    @PutMapping("{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee updatedEmployee) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow();
        employeeToUpdate.setFirstName(updatedEmployee.getFirstName());
        employeeToUpdate.setLastName(updatedEmployee.getLastName());
        employeeToUpdate.setPosition(updatedEmployee.getPosition());
        employeeToUpdate.setEMail(updatedEmployee.getEMail());
        employeeToUpdate.setPhoneNumber(updatedEmployee.getPhoneNumber());

        Employee employee1 = employeeRepository.save(employeeToUpdate);
    }
}
