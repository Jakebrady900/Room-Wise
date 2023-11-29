package com.roomwise.Room.RoomClassification;

import com.roomwise.Room.RoomType.RoomType;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class PremiumRoom implements RoomClassification {

    private BigDecimal _charge = BigDecimal.valueOf(80);

    @Override
    public BigDecimal getCharge() {
        return _charge;
    }

    @Override
    public void setCharge(BigDecimal Charge) {
        _charge = Charge;
    }
}
