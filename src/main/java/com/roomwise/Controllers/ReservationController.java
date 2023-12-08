package com.roomwise.Controllers;

import com.roomwise.Models.Reservation;
import com.roomwise.Services.ReservationService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;   //
    }

    // Endpoint to make a new reservation
    @PostMapping("/public/makeRes")
    public String makeReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    // Endpoint to update an existing reservation
    @PostMapping("/public/updateRes")
    public String updateReservation(@RequestBody Reservation reservation) {
        Boolean aBoolean = reservationService.updateReservation(reservation);
        return aBoolean ? "Updated successfully" : "No Such Reservation";
    }

    // Endpoint to retrieve all reservations
    @GetMapping("/admin/getAllRes")
    public List<Reservation> getAllReservation() {
        return reservationService.showReservations();
    }

    // Endpoint to get a specific reservation by ID
    @RequestMapping("/admin/getRes/{reservationId}")
    public Reservation getReservationByID(@PathVariable("reservationId") int reservationId) {
        return reservationService.findReservationById(reservationId);
    }

    // Endpoint to cancel a reservation by ID
    @RequestMapping("/admin/cancelReservation/{reservationId}")
    public String cancelReservationByID(@PathVariable("reservationId") int reservationId) {
        return reservationService.cancelReservation(reservationId);
    }

    // Endpoint to get the charge for a reservation by ID
    @RequestMapping("/admin/getCharge/{reservationId}")
    public String getCharge(@PathVariable Integer reservationId) {
        return reservationService.getCharge(reservationId).toString();
    }
}
