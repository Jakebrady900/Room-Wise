package com.roomwise.Services;


import com.roomwise.Models.Reservation;

import com.roomwise.ObservePayments.Observer;

import com.roomwise.Repositories.ReservationDAO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService  {

    private ReservationDAO reservationRepository;
    private Reservation reservation;
    //private PaymentService tempPaymentServices;

    public ReservationService(ReservationDAO reservationRepository, Reservation reservation) {
        this.reservationRepository = reservationRepository;
        this.reservation = reservation;
        //this.tempPaymentServices = tempPaymentServices;
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


//    public void addToObserver(PaymentService tempPaymentService) {
//        this.tempPaymentServices = tempPaymentService;
//        tempPaymentService.addObserver(this); //line adds the current instance of Reservation as an observer to the tempPaymentService
//    }

//    @Override
//    public void update(boolean PaymentState) {
//        reservation.setPaymentStatus(PaymentState);
//    }
}