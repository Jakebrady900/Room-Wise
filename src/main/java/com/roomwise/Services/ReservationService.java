package com.roomwise.Services;


import com.roomwise.Models.Payment;
import com.roomwise.Models.Reservation;
import com.roomwise.Models.Room;
import com.roomwise.ObservePayments.Observer;
import com.roomwise.Repositories.ReservationDAO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService implements Observer  {

    private ReservationDAO reservationRepository;
    private Reservation reservation;
    private PaymentService paymentService;
    private boolean paymentStatus;
    private Integer paymentId;
    private RoomService roomService;



    public ReservationService(ReservationDAO reservationRepository, Reservation reservation,PaymentService paymentService, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.paymentService = paymentService;
        this.paymentService.addObserver(this);
        this.roomService = roomService;
    }
    public Integer getPaymentId() {
        return this.paymentId != null ? this.paymentId : 0; // Return a default value if paymentId is null
    }
    public void saveReservation(Reservation reservation) {
        reservation.setReservationId(IdService.getNextReservationID());
        Payment payment = paymentService.createPayment();
        reservation.setPaymentId(payment.getPaymentId());
        this.paymentId = reservation.getPaymentId();
        this.reservation = reservation;
        paymentService.makePayment(paymentId);
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
    public void updatePaymentStatus(boolean status ) {
        reservation.setPaymentStatus(status);
        // Update payment status
    }

    public BigDecimal getCharge(Integer reservationId) {
        return reservationRepository.getCharge(reservationId);
    }


    public boolean isRoomAvailable(Integer roomId, LocalDate Qdate) {
        List<Reservation> reservations = showReservations();
        for (Reservation reservation : reservations) {
            if (reservation.getRoomsNumber().contains(roomId))  {
                if (reservation.getCheckinDate().isBefore(Qdate) && reservation.getCheckoutDate().isAfter(Qdate)) {
                    return false;
                }
            }
        }
        return true;
    }
}