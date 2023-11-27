package com.roomwise.Services;

import com.roomwise.Models.Reservation;
import com.roomwise.Repositories.ReservationDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationRepository;

    public void saveReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> showReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

}
