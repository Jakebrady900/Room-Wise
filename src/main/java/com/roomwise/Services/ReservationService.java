package com.roomwise.Services;

import com.roomwise.Models.Reservation;
import com.roomwise.Repositories.ReservationDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationDAO reservationRepository;

    public Reservation makeReservation(LocalDate checkinDate, LocalDate checkoutDate, Integer noOfPerson, Integer noOfRooms) {
        Reservation reservation = new Reservation();
        reservation.setCheckinDate(checkinDate);
        reservation.setCheckoutDate(checkoutDate);
        reservation.setNoOfPerson(noOfPerson);
        reservation.setNoOfRooms(noOfRooms);
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public List<Reservation> showReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

 
}
