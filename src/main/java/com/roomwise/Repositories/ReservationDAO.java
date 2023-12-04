package com.roomwise.Repositories;

import com.roomwise.Models.Reservation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ReservationDAO {

    // List<Reservation> findByCustomer(Customer customer);

    List<Reservation> ReservationDB = new ArrayList<>();

    public void save(Reservation room) {
        ReservationDB.add(room);
    }

    public List<Reservation> getReservations() {
        return ReservationDB;
    }

    public Reservation findById(Integer Id) {
        for (Reservation reservation : ReservationDB) {
            if (reservation.getReservationId() == Id) {
                return reservation;
            }
        }
        return null;
    }

    public String deleteReservationById(Integer Id) {
        if (findById(Id) != null) {
            ReservationDB.remove(Id);
            return "Reservation Canceled";
        } else {
            return "No Such Reservation";
        }
    }
}
