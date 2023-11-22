package com.roomwise.Models;

import com.roomwise.Factories.StandardRoom;

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

    public abstract String toHTMLString();

    public Integer get_roomID() {
        return _roomID;
    }

    public void set_roomID(Integer _roomID) {
        this._roomID = _roomID;
    }

    public RoomClassification get_roomClassification() {
        return _roomClassification;
    }

    public void set_roomClassification(RoomClassification _roomClassification) {
        this._roomClassification = _roomClassification;
    }

    public List<String> get_roomContents() {
        return _roomContents;
    }

    public void set_roomContents(List<String> _roomContents) {
        this._roomContents = _roomContents;
    }
}
