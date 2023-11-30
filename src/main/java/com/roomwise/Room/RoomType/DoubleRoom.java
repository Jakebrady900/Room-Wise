package com.roomwise.Room.RoomType;


import com.roomwise.Services.RoomMediator;
import com.roomwise.Room.RoomClassification.StandardRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoubleRoom extends RoomType {

    @Autowired
    public DoubleRoom(RoomMediator roomMediator) {
        set_roomClassification(new StandardRoom());
        set_capacity(2);
        set_basePrice(BigDecimal.valueOf(75));
        set_roomContents(new ArrayList<>(List.of(Content.DoubleBed)));
        set_mediator(roomMediator);
    }


}
