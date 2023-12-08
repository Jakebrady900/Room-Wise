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

    // Constructor injecting PaymentDAO and RoomDAO dependencies
    public ReservationDAO(PaymentDAO paymentDAO, RoomDAO roomDAO) {
        this.paymentDAO = paymentDAO;
        this.roomDAO = roomDAO;
    }

    List<Reservation> ReservationDB = new ArrayList<>(); // Database storing reservations

    // Method to save a reservation
    public void save(Reservation reservation) {
        ReservationDB.add(reservation);
    }

    // Method to retrieve all reservations
    public List<Reservation> getReservations() {
        return ReservationDB;
    }

    // Method to find a reservation by ID
    public Reservation findById(int Id) {
        for (Reservation reservation : ReservationDB) {
            if (reservation.getReservationId() == Id) {
                return reservation;
            }
        }
        return null;
    }

    // Method to delete a reservation by ID
    public String deleteReservationById(int Id) {
        for (Reservation reservation : ReservationDB) {
            if (reservation.getReservationId() == Id) {
                ReservationDB.remove(reservation);
                return "Reservation Canceled";
            }
        }
        return "No Such Reservation";
    }

    // Method to update a reservation
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

    // Method to update payment status of a reservation
    public void updatePaymentStatus(Integer reservationId, boolean newPaymentStatus) {
        Reservation reservationToUpdate = findById(reservationId);
        if (reservationToUpdate != null) {
            reservationToUpdate.setPaymentStatus(newPaymentStatus);
        }
        updateReservation(reservationToUpdate); // Updated successfully
    }

    // Method to calculate the total charge for a reservation
    public BigDecimal getCharge(Integer reservationId) {
        Reservation reservation = findById(reservationId);
        Payment payment = paymentDAO.findById(reservation.getPaymentId());
        BigDecimal charge = new BigDecimal(0);
        for (Integer number : reservation.getRoomsNumber()) {
            Room room = roomDAO.getRoom(number);
            if (room != null) {
                charge = charge.add(room.getCharge());
            }
        }
        payment.setAmount(charge); // Set payment amount for the reservation
        return charge;
    }
}
