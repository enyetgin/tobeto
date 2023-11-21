package com.tobeto.java.spring.controllers;

import com.tobeto.java.spring.entities.Rental;
import com.tobeto.java.spring.entities.Reservation;
import com.tobeto.java.spring.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationsController {

    private final ReservationRepository reservationRepository;

    public ReservationsController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAll(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    @GetMapping("{id}")
    public Reservation getById(@PathVariable int id){
        return reservationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Reservation reservation){
        reservationRepository.save(reservation);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Reservation reservationToDelete = reservationRepository.findById(id).orElseThrow();
        reservationRepository.delete(reservationToDelete);
    }

    @PutMapping("{id}")
    public void updateReservation(@PathVariable int id,@RequestBody Reservation updatedReservation) {
        Reservation reservationToUpdate = reservationRepository.findById(id).orElseThrow();
        reservationToUpdate.setCustomer(updatedReservation.getCustomer());
        reservationToUpdate.setVehicle(updatedReservation.getVehicle());
        reservationToUpdate.setStartDate(updatedReservation.getStartDate());
        reservationToUpdate.setEndDate(updatedReservation.getEndDate());
        reservationToUpdate.setTotalCost(updatedReservation.getTotalCost());


        Reservation reservation1 = reservationRepository.save(reservationToUpdate);
    }
}
