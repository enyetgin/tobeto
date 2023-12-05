package com.tobeto.java.spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "rentals")
@Entity
@Getter
@Setter
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    @Column(name ="rental_date")
    private LocalDate rentalDate;

    @Column(name ="return_date")
    private LocalDate returnDate;

    @Column(name="rental_cost")
    private BigDecimal rentalCost;

}
