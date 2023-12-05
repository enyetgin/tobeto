package com.tobeto.java.spring.services.dtos.requests.vehicle;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateVehicleRequest {
    private String brand;
    private String model;
    private int year;
    private String plateNumber;
    private boolean rentalStatus;
    private BigDecimal dailyRentalRate;
}
