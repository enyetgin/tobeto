package com.tobeto.java.spring.services.dtos.responses.rental;

import com.tobeto.java.spring.services.dtos.responses.customer.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalResponse {
    private BigDecimal rentalCost;
    private LocalDate rentalDate;
}
