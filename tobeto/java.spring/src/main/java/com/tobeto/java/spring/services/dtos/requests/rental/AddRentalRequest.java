package com.tobeto.java.spring.services.dtos.requests.rental;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.entities.Employee;
import com.tobeto.java.spring.entities.Reservation;
import com.tobeto.java.spring.entities.Vehicle;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class AddRentalRequest {
    private Employee employeeId;
    private Vehicle vehicleId;
    private Customer customerId;
    private Reservation reservationId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private BigDecimal totalCost;

}
