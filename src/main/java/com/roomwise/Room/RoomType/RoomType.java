package com.roomwise.Room.RoomType;

import com.roomwise.Room.Mediator.Mediator;
import com.roomwise.Room.RoomClassification.PremiumRoom;
import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomClassification.StandardRoom;

import java.math.BigDecimal;
import java.util.List;

public abstract class RoomType {
    private RoomClassification _roomClassification;
    private Mediator _mediator;
    private List<Content> _roomContents;
    private Integer _capacity;
    private BigDecimal _basePrice;

    public BigDecimal getCharge() {
        return _mediator.getCharge(this, _roomClassification);
    }


    public void upgradeRoom(){
        System.out.println("Upgrading room");
        if (this.get_roomClassification() instanceof StandardRoom) {
            this.set_roomClassification(new PremiumRoom());
        } else {
            System.out.println("Room is already premium");
        }
    }

    public void downgradeRoom(){
        System.out.println("Downgrading room");
        if (this.get_roomClassification() instanceof PremiumRoom) {
            this.set_roomClassification(new StandardRoom());
        } else {
            System.out.println("Room is already standard");
        }
    }

    public void addContents(List<Content> ContentsToAdd) {
        for (Content content : ContentsToAdd) {
            if (!_roomContents.contains(content)) {
                _roomContents.add(content);
            }
        }
    }

    public void removeContent(Content content) {
        if (_roomContents.contains(content)) {
            _roomContents.remove(content);
        }
    }

    public String getInfo() {
        return  "Room Class: " + getRoomClassification() + "<br>" +
                "Room Capacity: " + get_capacity() + "<br>" +
                "Base Price: " + get_basePrice() + "<br>" +
                "Room Contents: " + get_roomContents() + "<br>";

    }



    /*
    ================================================================================================
    GETTERS AND SETTERS
    ================================================================================================
     */
    public RoomClassification get_roomClassification() {
        return _roomClassification;
    }

    public void set_roomClassification(RoomClassification _roomClassification) {
        this._roomClassification = _roomClassification;
    }

    public List<Content> get_roomContents() {
        return _roomContents;
    }

    public void set_roomContents(List<Content> _roomContents) {
        this._roomContents = _roomContents;
    }

    public Integer get_capacity() {
        return _capacity;
    }

    public void set_capacity(Integer _capacity) {
        this._capacity = _capacity;
    }

    public BigDecimal get_basePrice() {
        return _basePrice;
    }

    public void set_basePrice(BigDecimal _basePrice) {
        this._basePrice = _basePrice;
    }

    public Mediator get_mediator() {
        return _mediator;
    }

    public void set_mediator(Mediator _mediator) {
        this._mediator = _mediator;
    }

    public String getRoomClassification() {
        return _roomClassification.getClass().getSimpleName();
    }
}
