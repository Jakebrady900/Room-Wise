package com.roomwise.Services;

import org.springframework.stereotype.Service;

@Service
public class IdService {
    /**
     * This class is used to generate unique IDs for the various entities in the system.
     * All methods and properties are static to allow any class be a client of this service,
     *     without having to inject it as a dependency.
     */

    private static Integer nextRoomNumber = 1;
    public static Integer getNextRoomNumber() {
        return nextRoomNumber++;
    }


    private static Integer nextCustomerID = 1;
    public static Integer getNextCustomerID() {
        return nextCustomerID++;
    }


    private static Integer nextReservationID = 1;
    public static Integer getNextReservationID() {
        return nextReservationID++;
    }


    private static Integer nextPaymentID = 1;
    public static Integer getNextPaymentID() {
        return nextPaymentID++;
    }
}
