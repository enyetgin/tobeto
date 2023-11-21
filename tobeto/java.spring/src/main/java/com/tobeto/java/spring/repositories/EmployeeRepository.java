package com.tobeto.java.spring.repositories;

import com.tobeto.java.spring.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
