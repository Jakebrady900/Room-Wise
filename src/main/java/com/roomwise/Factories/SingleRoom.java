package com.roomwise.Factories;

import com.roomwise.Models.Room;

import java.math.BigDecimal;
import java.util.Date;

public class SingleRoom extends Room {
    @Override
    public boolean isOccupied(Date date) {
        return false;
    }

    @Override
    public String displayDetails() {
        return null;
    }

    @Override
    public BigDecimal getCharge() {
        return null;
    }

    @Override
    public void upgradeRoom() {

    }
}
