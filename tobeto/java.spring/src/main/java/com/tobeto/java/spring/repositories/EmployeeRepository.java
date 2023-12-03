package com.tobeto.java.spring.repositories;

import com.tobeto.java.spring.entities.Employee;
import com.tobeto.java.spring.services.dtos.responses.employee.GetListEmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByLastNameLike(String lastName);
    @Query("SELECT new com.tobeto.java.spring.services.dtos.responses.employee.GetListEmployeeResponse(e.lastName, e.position) FROM Employee e WHERE e.lastName = :lastName AND e.position = :position")
    List<GetListEmployeeResponse> findByLastNameAndPosition(String lastName, String position);


}
