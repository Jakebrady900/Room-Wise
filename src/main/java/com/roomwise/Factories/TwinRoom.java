package com.roomwise.Factories;

import com.roomwise.Models.Room;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TwinRoom extends Room {

    public TwinRoom(int roomID) {
        set_roomID(roomID);
        set_roomClassification(new StandardRoom());
        set_roomContents(List.of("Single Bed", "Single Bed"));
    }
    @Override
    public boolean isOccupied(Date date) {
        return false;
    }

    @Override
    public String displayDetails() {
        return this.toString();
    }

    @Override
    public BigDecimal getCharge() {
        return null;
    }

    @Override
    public void upgradeRoom() {

    }

    @Override
    public String toHTMLString() {
        return "Twin Room <br>" +
                "_".repeat(80) + "<br>" +
                "Room Number: " + get_roomID() + "<br>" +
                "Room Classification: " + get_roomClassification().toString() + "<br>" +
                "Contents: " + get_roomContents().toString() + "<br>" +
                "_".repeat(80) + "<br>";
    }
}
