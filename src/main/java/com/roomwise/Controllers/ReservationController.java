package com.roomwise.Controllers;

import com.roomwise.DTO.ReservationDTO;
import com.roomwise.Models.Reservation;
import com.roomwise.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = reservationService.makeReservation(
                reservationDTO.getCheckinDate(),
                reservationDTO.getCheckoutDate(),
                reservationDTO.getNoOfPerson(),
                reservationDTO.getNoOfRooms()
        );

        ReservationDTO createdReservationDTO = convertToDTO(reservation);
        return new ResponseEntity<>(createdReservationDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/cancel/{reservationId}")
    public ResponseEntity<String> cancelReservation(@PathVariable Long reservationId) {
        reservationService.cancelReservation(reservationId);
        return new ResponseEntity<>("Reservation canceled", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<Reservation> reservations = reservationService.showReservations();
        List<ReservationDTO> reservationDTOs = reservations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(reservationDTOs, HttpStatus.OK);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long reservationId) {
        Optional<Reservation> reservation = reservationService.findReservationById(reservationId);
        return reservation.map(value -> new ResponseEntity<>(convertToDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private ReservationDTO convertToDTO(Reservation reservation) {
        return new ReservationDTO(
                reservation.getCheckinDate(),
                reservation.getCheckoutDate(),
                reservation.getNoOfPerson(),
                reservation.getNoOfRooms()
        );
    }
}
