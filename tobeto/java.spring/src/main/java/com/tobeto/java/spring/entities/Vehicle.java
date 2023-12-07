package com.tobeto.java.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "vehicles")
@Entity
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "rental_status")
    private boolean rentalStatus;

    @Column(name = "daily_rental_rate")
    private BigDecimal dailyRentalRate;

    @OneToMany(mappedBy = "vehicle")
    @JsonIgnore
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "vehicle")
    @JsonIgnore
    private List<Rental> rentals;
}
