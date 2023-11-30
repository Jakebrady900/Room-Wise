package com.roomwise.Room.RoomType;

import com.roomwise.Services.RoomMediator;
import com.roomwise.Room.RoomClassification.StandardRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class FamilyRoom extends RoomType {


    @Autowired
    public FamilyRoom(RoomMediator roomMediator) {
        set_roomClassification(new StandardRoom());
        set_capacity(4);
        set_basePrice(BigDecimal.valueOf(125));
        set_roomContents(new ArrayList<>(List.of(Content.DoubleBed, Content.SingleBed, Content.SingleBed)));
        set_mediator(roomMediator);
    }

}
