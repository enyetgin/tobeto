package com.tobeto.java.spring.services.abstracts;

import com.tobeto.java.spring.services.dtos.requests.reservation.AddReservationRequest;
import com.tobeto.java.spring.services.dtos.requests.reservation.UpdateReservationRequest;
import com.tobeto.java.spring.services.dtos.responses.reservation.GetListReservationResponse;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    void add(AddReservationRequest request);
    void delete(int id);

    void update(int id, UpdateReservationRequest request);

    List<GetListReservationResponse> getByBetweenStartDate(LocalDate startDate, LocalDate startDate2);
}
