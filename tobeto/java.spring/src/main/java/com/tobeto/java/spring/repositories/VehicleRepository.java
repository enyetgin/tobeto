package com.tobeto.java.spring.repositories;

import com.tobeto.java.spring.entities.Vehicle;
import com.tobeto.java.spring.services.dtos.responses.vehicle.GetListVehicleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query("SELECT new com.tobeto.java.spring.services.dtos.responses.vehicle.GetListVehicleResponse(v.rentalStatus, v.brand,v.model) FROM Vehicle v WHERE v.rentalStatus = :status")
    List<GetListVehicleResponse> findByRentalStatus(Boolean status);
}
