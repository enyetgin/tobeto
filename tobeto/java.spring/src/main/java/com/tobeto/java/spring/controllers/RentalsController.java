package com.tobeto.java.spring.controllers;

import com.tobeto.java.spring.entities.Employee;
import com.tobeto.java.spring.entities.Rental;
import com.tobeto.java.spring.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping
    public List<Rental> getAll(){
        List<Rental> rentals = rentalRepository.findAll();
        return rentals;
    }

    @GetMapping("{id}")
    public Rental getById(@PathVariable int id){
        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rental rental){
        rentalRepository.save(rental);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @PutMapping("{id}")
    public void updateRental(@PathVariable int id,@RequestBody Rental updatedRental) {
        Rental rentalToUpdate = rentalRepository.findById(id).orElseThrow();
        rentalToUpdate.setEmployee(updatedRental.getEmployee());
        rentalToUpdate.setVehicle(updatedRental.getVehicle());
        rentalToUpdate.setCustomer(updatedRental.getCustomer());
        rentalToUpdate.setReservation(updatedRental.getReservation());
        rentalToUpdate.setRentalDate(updatedRental.getRentalDate());
        rentalToUpdate.setRentalCost(updatedRental.getRentalCost());


        Rental rental1 = rentalRepository.save(rentalToUpdate);
    }
}
