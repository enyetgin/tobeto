package com.tobeto.java.spring.services.abstracts;

import com.tobeto.java.spring.entities.Reservation;
import com.tobeto.java.spring.services.dtos.requests.reservation.AddReservationRequest;
import com.tobeto.java.spring.services.dtos.requests.reservation.UpdateReservationRequest;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    void add(AddReservationRequest request);
    void delete(int id);

    void update(int id, UpdateReservationRequest request);

    List<Reservation> getByBetweenStartDate(LocalDate startDate, LocalDate startDate2);
}
