package com.roomwise.Room.RoomClassification;


import com.roomwise.Room.RoomType.Content;
import com.roomwise.Room.RoomType.RoomType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public class PremiumRoom implements RoomClassification {
    private BigDecimal _charge = BigDecimal.valueOf(80); //Stores the cost of the premium room itself

    @Override
    public BigDecimal getCharge(RoomType roomType) {
        return  get_charge();
    }
}
