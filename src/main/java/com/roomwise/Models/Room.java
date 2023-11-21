package com.roomwise.Models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class Room {
    private Integer _roomID;
    private RoomClassification _roomClassification;
    private List<String> _roomContents;

    public abstract boolean isOccupied(Date date);

    public abstract String displayDetails();

    public abstract BigDecimal getCharge();

    public abstract void upgradeRoom();
}
