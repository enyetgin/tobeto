package com.tobeto.java.spring.controllers;

import com.tobeto.java.spring.entities.Reservation;
import com.tobeto.java.spring.services.abstracts.ReservationService;
import com.tobeto.java.spring.services.dtos.requests.reservation.AddReservationRequest;
import com.tobeto.java.spring.services.dtos.requests.reservation.UpdateReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationsController {

    private ReservationService reservationService;
    @Autowired
    public ReservationsController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void add(@RequestBody AddReservationRequest request){
        reservationService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        reservationService.delete(id);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateReservationRequest request){
        reservationService.update(id, request);
    }

    @GetMapping("between")
    public List<Reservation> getByStartDate(@RequestParam LocalDate startDate, LocalDate startDate2){
        return reservationService.getByBetweenStartDate(startDate,startDate2);
    }
}
