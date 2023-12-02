package com.roomwise.Room.RoomType;


import com.roomwise.Room.RoomClassification.StandardRoom;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoubleRoom extends RoomType {

    public DoubleRoom() {
        set_roomClassification(new StandardRoom());
        set_capacity(2);
        set_basePrice(BigDecimal.valueOf(75));
        set_roomContents(new ArrayList<>(List.of(Content.DoubleBed)));
    }


}
