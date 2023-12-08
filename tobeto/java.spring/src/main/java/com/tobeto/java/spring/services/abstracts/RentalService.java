package com.tobeto.java.spring.services.abstracts;

import com.tobeto.java.spring.entities.Rental;
import com.tobeto.java.spring.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.java.spring.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.java.spring.services.dtos.responses.rental.GetListRentalResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RentalService {
    void add(AddRentalRequest request);
    void delete(int id);
    void update(int id, UpdateRentalRequest request);

    List<GetListRentalResponse> getByRentalCostDto(BigDecimal cost);

    List<GetListRentalResponse> getByRentalDateDto(LocalDate date);

}