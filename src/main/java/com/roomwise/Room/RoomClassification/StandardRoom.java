package com.roomwise.Room.RoomClassification;

import com.roomwise.Room.RoomType.Content;
import com.roomwise.Room.RoomType.RoomType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class StandardRoom implements RoomClassification {

    @Override
    public BigDecimal getCharge(RoomType roomType) {
        BigDecimal Charge;

        Charge = BigDecimal.valueOf(0);
        for (Content content : roomType.get_roomContents()) {
            Charge = Charge.add(content.getCost());
        }

        return Charge;
    }

}
