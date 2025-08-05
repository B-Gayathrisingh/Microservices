package com.example.flightreservation.controller;

import com.example.flightreservation.entity.Reservation;
import com.example.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/flight/{flightId}")
    public Reservation makeReservation(@PathVariable Long flightId, @RequestBody Reservation reservation) {
        return reservationService.makeReservation(flightId, reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/flight/{flightId}")
    public List<Reservation> getReservationsByFlightId(@PathVariable Long flightId) {
        return reservationService.getReservationsByFlightId(flightId);
    }

    @DeleteMapping("/{reservationId}")
    public void cancelReservation(@PathVariable Long reservationId) {
        reservationService.cancelReservation(reservationId);
    }
}
