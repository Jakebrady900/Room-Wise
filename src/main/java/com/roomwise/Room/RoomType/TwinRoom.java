package com.roomwise.Room.RoomType;

import com.roomwise.Room.Mediator.RoomMediator;
import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomClassification.StandardRoom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TwinRoom extends RoomType {

    public TwinRoom() {
        set_roomClassification(new StandardRoom());
        set_capacity(2);
        set_basePrice(BigDecimal.valueOf(90));
        set_roomContents(new ArrayList<>(List.of(Content.SingleBed, Content.SingleBed)));
        set_mediator(new RoomMediator());
    }

}
