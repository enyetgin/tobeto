package com.tobeto.java.spring.repositories;

import com.tobeto.java.spring.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByStartDateBetween(LocalDate startDate, LocalDate startDate2);


}
