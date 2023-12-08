package com.roomwise.Services;

import org.springframework.stereotype.Service;

@Service
public class IdService {
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
