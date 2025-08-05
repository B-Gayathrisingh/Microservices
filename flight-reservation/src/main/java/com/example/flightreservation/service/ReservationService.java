package com.example.flightreservation.service;

import com.example.flightreservation.entity.Flight;
import com.example.flightreservation.entity.Reservation;
import com.example.flightreservation.exception.FlightNotFoundException;
import com.example.flightreservation.exception.NotEnoughSeatsException;
import com.example.flightreservation.repository.FlightRepository;
import com.example.flightreservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightRepository flightRepository;

    public Reservation makeReservation(Long flightId, Reservation reservation) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found with ID: " + flightId));

        if (reservation.getSeatsBooked() > flight.getSeatsAvailable()) {
            throw new NotEnoughSeatsException("Not enough seats available");
        }

        // Deduct seats
        flight.setSeatsAvailable(flight.getSeatsAvailable() - reservation.getSeatsBooked());
        reservation.setFlight(flight);
        reservation.setReservedAt(LocalDateTime.now());

        // Save both
        flightRepository.save(flight);
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByFlightId(Long flightId) {
        return reservationRepository.findByFlightId(flightId);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        Flight flight = reservation.getFlight();

        // Restore seats
        flight.setSeatsAvailable(flight.getSeatsAvailable() + reservation.getSeatsBooked());

        // Save flight & delete reservation
        flightRepository.save(flight);
        reservationRepository.deleteById(reservationId);
    }
}
