package com.roomwise.Room.RoomType;

import com.roomwise.Room.Mediator.RoomMediator;
import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomClassification.StandardRoom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DoubleRoom extends RoomType {

    public DoubleRoom() {
        set_roomClassification(new StandardRoom());
        set_capacity(2);
        set_basePrice(BigDecimal.valueOf(75));
        set_roomContents(new ArrayList<>(List.of(Content.DoubleBed)));
        set_mediator(new RoomMediator());
    }


}
