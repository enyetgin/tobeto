package com.tobeto.java.spring.repositories;

import com.tobeto.java.spring.entities.Rental;
import com.tobeto.java.spring.services.dtos.responses.rental.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    @Query("SELECT new com.tobeto.java.spring.services.dtos.responses.rental.GetListRentalResponse(r.rentalCost, r.rentalDate) FROM Rental r WHERE r.rentalCost > :cost")
    List<GetListRentalResponse> findByRentalCost(BigDecimal cost);
    @Query("SELECT new com.tobeto.java.spring.services.dtos.responses.rental.GetListRentalResponse(r.rentalCost, r.rentalDate) FROM Rental r WHERE r.rentalDate >= :date")
    List<GetListRentalResponse> findByRentalDate(LocalDate date);
}
