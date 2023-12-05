package com.roomwise.Room.RoomClassification;

import com.roomwise.Room.RoomType.Content;
import com.roomwise.Room.RoomType.RoomType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class StandardRoom implements RoomClassification {
    private BigDecimal _charge = BigDecimal.valueOf(0);

    @Override
    public BigDecimal getCharge(RoomType roomType) {
        BigDecimal Charge;

        Charge = get_charge();
        for (Content content : roomType.get_roomContents()) {
            Charge = Charge.add(content.getCost());
        }

        return Charge;
    }

}
