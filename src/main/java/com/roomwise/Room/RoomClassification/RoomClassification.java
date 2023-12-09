package com.roomwise.Room.RoomClassification;

import com.roomwise.Room.RoomType.RoomType;

import java.math.BigDecimal;

public interface RoomClassification {
    /**
     * RoomClassification interface is used to classify the room type.
     * It currently has two concrete implementations: Premium and Standard.
     * The method for calculating the charge is implemented in the concrete classes.
     * The RoomClassification interface represents the Implementation in the Bridge Design pattern.
     */
    public BigDecimal getCharge(RoomType roomType);
}
