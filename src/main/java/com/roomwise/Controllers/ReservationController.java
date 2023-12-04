package com.roomwise.Controllers;

import com.roomwise.Models.Reservation;
import com.roomwise.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/public/makeRes")
    public String makeReservation(@RequestBody Reservation resrvation) {
        reservationService.saveReservation(resrvation);
        return "saved sucessfully";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/getAllRes")
    public List<Reservation> getAllReservation() {
        return reservationService.showReservations();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/getRes/{id}")
    public Reservation getReservationByID(@PathVariable("reservationId") Integer Id) {
       return reservationService.findReservationById(Id);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/cancelReservation/{id}")
    public String cancelReservationByID(@PathVariable("reservationId") Integer Id) {
        return reservationService.cancelReservation(Id);
    }
}
