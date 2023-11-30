package com.roomwise.Room.RoomType;

import com.roomwise.Services.Mediator;
import com.roomwise.Room.RoomClassification.PremiumRoom;
import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomClassification.StandardRoom;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@Embeddable
public abstract class RoomType {
    @Embedded
    private RoomClassification _roomClassification;
    @Embedded
    private List<Content> _roomContents;
    private Integer _capacity;
    private BigDecimal _basePrice;
    private Mediator _mediator;

    public BigDecimal getCharge() {
        return _mediator.getCharge(this, get_roomClassification());
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
        return  "Room Class: " + get_roomClassification() + "<br>" +
                "Room Capacity: " + get_capacity() + "<br>" +
                "Base Price: " + get_basePrice() + "<br>" +
                "Room Contents: " + get_roomContents() + "<br>";

    }



}
