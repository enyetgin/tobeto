package com.tobeto.java.spring.services.concretes;

import com.tobeto.java.spring.entities.Customer;
import com.tobeto.java.spring.entities.Reservation;
import com.tobeto.java.spring.entities.Vehicle;
import com.tobeto.java.spring.repositories.ReservationRepository;
import com.tobeto.java.spring.services.abstracts.CustomerService;
import com.tobeto.java.spring.services.abstracts.ReservationService;
import com.tobeto.java.spring.services.abstracts.VehicleService;
import com.tobeto.java.spring.services.dtos.requests.reservation.AddReservationRequest;
import com.tobeto.java.spring.services.dtos.requests.reservation.UpdateReservationRequest;
import com.tobeto.java.spring.services.dtos.responses.reservation.GetListReservationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationManager implements ReservationService {
    private ReservationRepository reservationRepository;
    private final CustomerService customerService;
    private final VehicleService vehicleService;
    @Autowired
    public ReservationManager(ReservationRepository reservationRepository, CustomerService customerService, VehicleService vehicleService) {
        this.reservationRepository = reservationRepository;
        this.customerService = customerService;
        this.vehicleService = vehicleService;
    }

    @Override
    public void add(AddReservationRequest request){
        //Business Rule
        Reservation startDate = reservationRepository.findByStartDate(request.getStartDate());
        Reservation endDate = reservationRepository.findByEndDate(request.getEndDate());

        if(startDate == endDate) {
            throw new RuntimeException("Kiralama aynı gün için yapılamaz!");
        }

        Reservation reservation = new Reservation();
        reservation.setStartDate(request.getStartDate());
        reservation.setEndDate(request.getEndDate());
        reservation.setTotalCost(request.getTotalCost());

        //FK Alanları
        Customer customer = customerService.getById(request.getCustomerId());
        reservation.setCustomer(customer);
        Vehicle vehicle = vehicleService.getById(request.getVehicleId());
        reservation.setVehicle(vehicle);

        reservationRepository.save(reservation);
    }

    public void delete(int id){
        Reservation deleteToReservation = reservationRepository.findById(id).orElseThrow();
        reservationRepository.delete(deleteToReservation);
    }

    @Override
    public void update(int id, UpdateReservationRequest request){
        Reservation updateToReservation = reservationRepository.findById(id).orElseThrow();
        updateToReservation.setCustomer(request.getCustomerId());
        updateToReservation.setVehicle(request.getVehicleId());
        updateToReservation.setStartDate(request.getStartDate());
        updateToReservation.setEndDate(request.getEndDate());
        updateToReservation.setTotalCost(request.getTotalCost());
        reservationRepository.save(updateToReservation);

    }

    @Override
    public List<GetListReservationResponse> getByBetweenStartDate(LocalDate startDate, LocalDate startDate2) {
        return reservationRepository.findByStartDateBetween(startDate,startDate2)
                .stream()
                .map((Reservation)-> new GetListReservationResponse(Reservation.getStartDate(),Reservation.getEndDate()))
                .toList();
    }
}
