package com.tobeto.java.spring.repositories;

import com.tobeto.java.spring.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
