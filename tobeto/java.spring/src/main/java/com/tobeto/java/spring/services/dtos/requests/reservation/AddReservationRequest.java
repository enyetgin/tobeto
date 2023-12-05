package com.tobeto.java.spring.services.dtos.requests.reservation;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.entities.Vehicle;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class AddReservationRequest {
    private Customer customerId;
    private Vehicle vehicleId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalCost;

}
