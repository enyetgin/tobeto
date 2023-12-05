package com.tobeto.java.spring.services.concretes;

import com.tobeto.java.spring.entities.Vehicle;
import com.tobeto.java.spring.repositories.VehicleRepository;
import com.tobeto.java.spring.services.abstracts.VehicleService;
import com.tobeto.java.spring.services.dtos.requests.vehicle.AddVehicleRequest;
import com.tobeto.java.spring.services.dtos.requests.vehicle.UpdateVehicleRequest;
import com.tobeto.java.spring.services.dtos.responses.vehicle.GetListVehicleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleManager implements VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleManager(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void add(AddVehicleRequest request){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setYear(request.getYear());
        vehicle.setPlateNumber(request.getPlateNumber());
        vehicle.setRentalStatus(request.isRentalStatus());
        vehicle.setDailyRentalRate(request.getDailyRentalRate());
        vehicleRepository.save(vehicle);
    }

    @Override
    public void delete(int id){
        Vehicle deleteToVehicle = vehicleRepository.findById(id).orElseThrow();
        vehicleRepository.delete(deleteToVehicle);
    }

    @Override
    public void update(int id, UpdateVehicleRequest request){
        Vehicle updateToVehicle = vehicleRepository.findById(id).orElseThrow();
        updateToVehicle.setBrand(request.getBrand());
        updateToVehicle.setModel(request.getModel());
        updateToVehicle.setYear(request.getYear());
        updateToVehicle.setPlateNumber(request.getPlateNumber());
        updateToVehicle.setRentalStatus(request.isRentalStatus());
        updateToVehicle.setDailyRentalRate(request.getDailyRentalRate());
        vehicleRepository.save(updateToVehicle);
    }

    @Override
    public List<GetListVehicleResponse> getByRentalStatus(Boolean status) {
        return vehicleRepository.findByRentalStatus(status)
                .stream()
                .map((Vehicle)-> new GetListVehicleResponse(Vehicle.getStatus(), Vehicle.getBrand(), Vehicle.getModel()))
                .toList();
    }


}
