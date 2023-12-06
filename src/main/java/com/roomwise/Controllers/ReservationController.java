package com.roomwise.Controllers;

import com.roomwise.Models.Reservation;
import com.roomwise.Services.ReservationService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/public/makeRes")
    public String makeReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "saved successfully";
    }

    @PostMapping("/public/updateRes")
    public String updateReservation(@RequestBody Reservation reservation) {
        Boolean aBoolean = reservationService.updateReservation(reservation);
        return aBoolean?"Updated successfully":"No Such Reservation";
    }

    @GetMapping("/admin/getAllRes")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Reservation> getAllReservation(Authentication authentication) {
//        System.out.println(authentication.getAuthorities()); // Print user's authorities/roles
        return reservationService.showReservations();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/admin/getRes/{reservationId}")
    public Reservation getReservationByID(@PathVariable("reservationId") int reservationId) {
        return reservationService.findReservationById(reservationId);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/admin/cancelReservation/{reservationId}")
    public String cancelReservationByID(@PathVariable("reservationId") int reservationId) {
        return reservationService.cancelReservation(reservationId);
    }

}