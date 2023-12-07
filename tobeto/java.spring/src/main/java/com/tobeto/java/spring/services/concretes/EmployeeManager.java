package com.tobeto.java.spring.services.concretes;

import com.tobeto.java.spring.entities.Employee;
import com.tobeto.java.spring.repositories.EmployeeRepository;
import com.tobeto.java.spring.services.abstracts.EmployeeService;
import com.tobeto.java.spring.services.dtos.requests.employee.AddEmployeeRequest;
import com.tobeto.java.spring.services.dtos.requests.employee.UpdateEmployeeRequest;
import com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse;
import com.tobeto.java.spring.services.dtos.responses.employee.GetListEmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void add(AddEmployeeRequest request){
        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setPosition(request.getPosition());
        employee.setEMail(request.getEMail());
        employee.setPhoneNumber(request.getPhoneNumber());
        employeeRepository.save(employee);
    }

    public void delete(int id){
        Employee deleteToEmployee = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(deleteToEmployee);
    }

    @Override
    public void update(int id, UpdateEmployeeRequest request){
        Employee updateToEmployee = employeeRepository.findById(id).orElseThrow();
        updateToEmployee.setFirstName(request.getFirstName());
        updateToEmployee.setLastName(request.getLastName());
        updateToEmployee.setPosition(request.getPosition());
        updateToEmployee.setEMail(request.getEMail());
        updateToEmployee.setPhoneNumber(request.getPhoneNumber());
        employeeRepository.save(updateToEmployee);
    }

    @Override
    public List<Employee> getByLastName(String lastName) {
        return employeeRepository.findByLastNameLike(lastName);
    }

    @Override
    public List<GetListEmployeeResponse> getByLastNameAndPositionDto(String lastName, String position) {
        return employeeRepository.findByLastNameAndPosition(lastName,position)
                .stream()
                .map((Employee) -> new GetListEmployeeResponse(Employee.getLastName(), Employee.getPosition()))
                .toList();
    }




}
