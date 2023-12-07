package com.tobeto.java.spring.controllers;


import com.tobeto.java.spring.entities.Rental;
import com.tobeto.java.spring.entities.Vehicle;
import com.tobeto.java.spring.repositories.VehicleRepository;
import com.tobeto.java.spring.services.abstracts.VehicleService;
import com.tobeto.java.spring.services.dtos.requests.vehicle.AddVehicleRequest;
import com.tobeto.java.spring.services.dtos.requests.vehicle.UpdateVehicleRequest;
import com.tobeto.java.spring.services.dtos.responses.vehicle.GetListVehicleResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
public class VehiclesController {

    private VehicleService vehicleService;

    public VehiclesController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public void add(@RequestBody AddVehicleRequest request){
        vehicleService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        vehicleService.delete(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateVehicleRequest request){
        vehicleService.update(id, request);
    }

    @GetMapping("status")
    public List<GetListVehicleResponse> getByRentalStatusDto(@RequestParam Boolean status){
        return vehicleService.getByRentalStatus(status);
    }


    /*private final VehicleRepository vehicleRepository;

    public VehiclesController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public List<Vehicle> getAll(){
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles;
    }

    @GetMapping("{id}")
    public Vehicle getById(@PathVariable int id) {
        return vehicleRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Vehicle vehicleToDelete = vehicleRepository.findById(id).orElseThrow();
        vehicleRepository.delete(vehicleToDelete);
    }

    @PutMapping("{id}")
    public void updateVehicle(@PathVariable int id,@RequestBody Vehicle updatedVehicle) {
        Vehicle vehicleToUpdate = vehicleRepository.findById(id).orElseThrow();
        vehicleToUpdate.setBrand(updatedVehicle.getBrand());
        vehicleToUpdate.setModel(updatedVehicle.getModel());
        vehicleToUpdate.setYear(updatedVehicle.getYear());
        vehicleToUpdate.setPlateNumber(updatedVehicle.getPlateNumber());
        vehicleToUpdate.setDailyRentalRate(updatedVehicle.getDailyRentalRate());


        Vehicle vehicle1 = vehicleRepository.save(vehicleToUpdate);
    }*/
}
