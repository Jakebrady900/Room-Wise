package com.roomwise.Room.Mediator;

import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomClassification.StandardRoom;
import com.roomwise.Room.RoomType.Content;
import com.roomwise.Room.RoomType.RoomType;

import java.math.BigDecimal;

public class RoomMediator implements Mediator {

    public BigDecimal getCharge(RoomType roomType, RoomClassification roomClassification) {
        BigDecimal Charge;

        Charge = roomClassification.getCharge();
        if (roomClassification instanceof StandardRoom) {
            for (Content content : roomType.get_roomContents()) {
                Charge = Charge.add(content.getCost());
            }
        }

        Charge = Charge.add(roomType.get_basePrice());

        return Charge;
    }
}
