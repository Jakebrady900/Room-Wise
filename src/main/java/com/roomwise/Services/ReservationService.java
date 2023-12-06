package com.roomwise.Services;


import com.roomwise.Models.Reservation;
import com.roomwise.ObservePayments.Observer;
import com.roomwise.Repositories.ReservationDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements Observer  {

    private ReservationDAO reservationRepository;
    private Reservation reservation;
    private PaymentService paymentService;
    private boolean paymentStatus;
    private Integer Id;


    public ReservationService(ReservationDAO reservationRepository, Reservation reservation,PaymentService paymentService) {
        this.reservationRepository = reservationRepository;
        this.reservation = reservation;
        this.paymentService = paymentService;
        this.paymentService.addObserver(this);
        this.Id = reservation.getReservationId();
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
    public Boolean updateReservation(Reservation reservation) {
        return reservationRepository.updateReservation(reservation);
    }

    public List<Reservation> showReservations() {
        return reservationRepository.getReservations();
    }

    public Reservation findReservationById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public String cancelReservation(int reservationId) {
        return reservationRepository.deleteReservationById(reservationId);
    }


    @Override
    public void updatePaymentStatus(boolean status) {
        reservationRepository.updatePaymentStatus(Id, status);
        //update payment status
    }


}