package com.roomwise.Controllers;

import com.roomwise.Models.Reservation;
import com.roomwise.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/makeRes")
    public String makeReservation(@RequestBody Reservation resrvation) {
        reservationService.saveReservation(resrvation);
        return "saved sucessfully";
    }

    @GetMapping("/getAllRes")
    public List<Reservation> getAllReservation() {
        return reservationService.showReservations();
    }

    @GetMapping("/getRes/{id}")
    public String getReservationByID(@PathVariable Long Id) {
        if (reservationService.findReservationById(Id).isPresent()) {
            return "reserved : " + reservationService.findReservationById(Id).get();
        } else {
            return "no such reservation";
        }
    }

}
