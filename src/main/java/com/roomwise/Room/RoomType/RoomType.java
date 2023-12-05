package com.roomwise.Room.RoomType;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomClassification.PremiumRoom;
import com.roomwise.Room.RoomClassification.RoomClassification;
import com.roomwise.Room.RoomClassification.StandardRoom;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public abstract class RoomType {
    /**
        RoomType is an object composing the Room object, which determine the room size.
        RoomType has four concrete implementations; Single, Twin, Double, and Family.
        RoomType is composed of a list of roomContents, the capacity of the room, and the base price.
        RoomType is also a composition of the roomClassification object, which determines the mechanics of
                the costs for each item in the room contents list.
     */
    private RoomClassification _roomClassification;
    private List<Content> _roomContents;
    private Integer _capacity;
    private BigDecimal _basePrice;

    public BigDecimal getCharge() {
        return _roomClassification.getCharge(this).add(get_basePrice());
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
