package com.tobeto.java.spring.controllers;

import com.tobeto.java.spring.entities.Employee;
import com.tobeto.java.spring.entities.Rental;
import com.tobeto.java.spring.repositories.RentalRepository;
import com.tobeto.java.spring.services.abstracts.RentalService;
import com.tobeto.java.spring.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.java.spring.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.java.spring.services.dtos.responses.rental.GetListRentalResponse;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest request){
        rentalService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateRentalRequest request){
        rentalService.update(id, request);
    }

    @GetMapping("cost")
    public List<GetListRentalResponse> getByRentalCostDto(@RequestParam BigDecimal cost){
        return rentalService.getByRentalCostDto(cost);
    }

    @GetMapping("date")
    public List<GetListRentalResponse> getByRentalDateDto(@RequestParam LocalDate date){
        return  rentalService.getByRentalDateDto(date);
    }
}
