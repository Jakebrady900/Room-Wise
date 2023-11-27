package com.roomwise.Room.Mediator;

import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomType.RoomType;

import java.math.BigDecimal;

public interface Mediator {
    BigDecimal getCharge(RoomType roomType, RoomClassification roomClassification);
}
