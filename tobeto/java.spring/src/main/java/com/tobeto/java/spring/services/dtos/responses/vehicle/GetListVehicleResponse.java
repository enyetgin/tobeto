package com.tobeto.java.spring.services.dtos.responses.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListVehicleResponse {
    private Boolean status;
    private String brand;
    private String model;
}
