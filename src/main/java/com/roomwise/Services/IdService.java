package com.roomwise.Services;

import org.springframework.stereotype.Service;

@Service
public class IdService {
    private static Integer nextRoomNumber = 1; // Counter for generating room numbers

    // Get the next available room number
    public static Integer getNextRoomNumber() {
        return nextRoomNumber++;
    }

    private static Integer nextCustomerID = 1; // Counter for generating customer IDs

    // Get the next available customer ID
    public static Integer getNextCustomerID() {
        return nextCustomerID++;
    }

    private static Integer nextReservationID = 1; // Counter for generating reservation IDs

    // Get the next available reservation ID
    public static Integer getNextReservationID() {
        return nextReservationID++;
    }

    private static Integer nextPaymentID = 1; // Counter for generating payment IDs

    // Get the next available payment ID
    public static Integer getNextPaymentID() {
        return nextPaymentID++;
    }
}
