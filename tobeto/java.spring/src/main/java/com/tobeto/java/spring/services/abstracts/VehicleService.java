package com.tobeto.java.spring.services.abstracts;

import com.tobeto.java.spring.entities.Vehicle;
import com.tobeto.java.spring.services.dtos.requests.vehicle.AddVehicleRequest;
import com.tobeto.java.spring.services.dtos.requests.vehicle.UpdateVehicleRequest;
import com.tobeto.java.spring.services.dtos.responses.vehicle.GetListVehicleResponse;

import java.util.List;

public interface VehicleService {
    void add(AddVehicleRequest request);

    void delete(int id);

    void update(int id, UpdateVehicleRequest request);

    List<GetListVehicleResponse> getByRentalStatus (Boolean status);

    Vehicle getById(int id);

}
