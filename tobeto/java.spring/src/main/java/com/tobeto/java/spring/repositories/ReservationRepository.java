package com.tobeto.java.spring.repositories;

import com.tobeto.java.spring.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
