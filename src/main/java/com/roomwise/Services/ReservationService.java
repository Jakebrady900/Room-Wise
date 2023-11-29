package com.roomwise.Services;

import com.roomwise.Models.Room;
import com.roomwise.ObservePayments.Observer;
import com.roomwise.ObservePayments.Subject;
import com.roomwise.Repositories.ReservationDAO;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements Observer {

    //@Autowired
    private ReservationDAO reservationRepository;

    public void saveReservation(Reservation reservation) {
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

    
    public void addToObserver(Subject tempPaymentService) {
        this.tempPaymentServices = tempPaymentService;
        tempPaymentService.addObserver(this); //line adds the current instance of Reservation as an observer to the tempPaymentService
    }

    @Override
    public void update(boolean PaymentState) {
        reservation.setPaymentStatus(PaymentState);
    }

}
