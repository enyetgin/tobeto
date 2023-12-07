package com.tobeto.java.spring.services.dtos.requests.reservation;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.entities.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddReservationRequest {
    private int customerId;
    private int vehicleId;

    @NotNull(message = "Boş Geçilemez")
    private LocalDate startDate;

    @NotNull(message = "Boş Geçilemez")
    private LocalDate endDate;

    @Positive(message = "Pozitif bir sayı olmalıdır.")
    private BigDecimal totalCost;

}
