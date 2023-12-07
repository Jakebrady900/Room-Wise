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
        reservation.setPaymentId(IdService.getNextPaymentID());
        this.paymentId = reservation.getPaymentId();
        this.reservation = reservation;
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
        Reservation reservation = findReservationById(reservationId);
        Payment payment = paymentService.findPaymentById(reservation.getPaymentId());
        BigDecimal charge = new BigDecimal(0);
        for (Integer number : reservation.getRoomsNumber()) {
            Room room = roomService.getRoom(number);
            if (room != null) {
                charge.add(room.getCharge());
            }
        }
        payment.setAmount(charge);
        return charge;
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