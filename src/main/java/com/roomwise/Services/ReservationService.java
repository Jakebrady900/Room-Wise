package com.roomwise.Services;


import com.roomwise.Models.Reservation;

import com.roomwise.ObservePayments.Observer;

import com.roomwise.Repositories.ReservationDAO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService  {


    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    private final ReservationDAO reservationRepository;
    private Reservation reservation;
    public ReservationService(ReservationDAO reservationRepository, Reservation reservation) {
        this.reservationRepository = reservationRepository;
        this.reservation = reservation;
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> showReservations() {
        return reservationRepository.getReservations();
    }

    public Reservation findReservationById(Integer reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public String cancelReservation(Integer reservationId) {
        return reservationRepository.deleteReservationById(reservationId);
    }
}