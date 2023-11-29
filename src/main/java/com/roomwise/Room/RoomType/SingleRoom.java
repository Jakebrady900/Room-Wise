package com.roomwise.Room.RoomType;


import com.roomwise.Room.Mediator.RoomMediator;
import com.roomwise.Room.RoomClassification.StandardRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class SingleRoom extends RoomType {

    @Autowired
    public SingleRoom(RoomMediator roomMediator) {
        set_roomClassification(new StandardRoom());
        set_capacity(1);
        set_basePrice(BigDecimal.valueOf(50));
        set_roomContents(new ArrayList<>(List.of(Content.SingleBed)));
        set_mediator(roomMediator);
    }

}
