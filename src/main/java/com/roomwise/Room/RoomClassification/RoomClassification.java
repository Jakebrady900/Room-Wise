package com.roomwise.Room.RoomClassification;

import com.roomwise.Room.RoomType.RoomType;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

public interface RoomClassification {

    public BigDecimal getCharge();
    public void setCharge(BigDecimal premiumCharge);

}
