package com.tobeto.java.spring.services.dtos.responses.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListReservationResponse {
    private LocalDate startDate;
    private LocalDate endDate;
}
