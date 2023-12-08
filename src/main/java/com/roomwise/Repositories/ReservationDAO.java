package com.roomwise.Repositories;

import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.roomwise.Models.Payment;
import com.roomwise.Models.Reservation;
import com.roomwise.Models.Room;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDAO {

    PaymentDAO paymentDAO;
    RoomDAO roomDAO;

    public ReservationDAO(PaymentDAO paymentDAO, RoomDAO roomDAO) {
        this.paymentDAO = paymentDAO;
        this.roomDAO = roomDAO;
    }

    List<Reservation> ReservationDB = new ArrayList<>();

    public void save(Reservation reservation) {
//        reservation.setCustomerId(customer.getCustomerId());
        ReservationDB.add(reservation);
    }


    public List<Reservation> getReservations() {
        return ReservationDB;
    }


    public Reservation findById(int Id) {
        for (Reservation reservation : ReservationDB) {
            if (reservation.getReservationId() == Id) {
                return reservation;
            }
        }
        return null;
    }

    public String deleteReservationById(int Id) {

        for (Reservation reservation : ReservationDB) {
            if (reservation.getReservationId() == Id) {
                ReservationDB.remove(reservation);
                return "Reservation Canceled";
            }
        }
        return "No Such Reservation";
    }

    public Boolean updateReservation(Reservation updatedReservation) {
        for (int i = 0; i < ReservationDB.size(); i++) {
            Reservation reservation = ReservationDB.get(i);
            if (reservation.getReservationId().equals(updatedReservation.getReservationId())) {
                ReservationDB.set(i, updatedReservation);
                return true; // Updated successfully
            }
        }
        return false; // Item not found
    }

    public void updatePaymentStatus(Integer reservationId, boolean newPaymentStatus) {
        Reservation reservationToUpdate = findById(reservationId);
        if (reservationToUpdate != null) {
            reservationToUpdate.setPaymentStatus(newPaymentStatus);
        }
        updateReservation(reservationToUpdate);  // Updated successfully
    }

    public BigDecimal getCharge(Integer reservationId) {
        Reservation reservation = findById(reservationId);
        Payment payment = paymentDAO.findById(reservation.getPaymentId());
        System.out.println(payment);
        BigDecimal charge = new BigDecimal(0);
        for (Integer number : reservation.getRoomsNumber()) {
            Room room = roomDAO.getRoom(number);
            if (room != null) {
                charge = charge.add(room.getCharge());
            }
        }
        payment.setAmount(charge);
        return charge;
    }
}