package com.example.flightreservation.repository;

import com.example.flightreservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    
    List<Reservation> findByFlightId(Long flightId);
}
