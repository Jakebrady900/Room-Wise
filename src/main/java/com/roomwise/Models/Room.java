package com.roomwise.Models;


import com.roomwise.Room.RoomType.RoomType;
import com.roomwise.Services.RoomMediator;
import com.roomwise.Services.RoomService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
public class Room {

    private String id;
    private Integer roomNumber;
    private static int nextRoomNumber = 1;
    private RoomType roomType;

    public Room(RoomType roomType) {
        id = UUID.randomUUID().toString();
        this.roomNumber = getNextRoomNumber();
        setRoomType(roomType);
    }

    public String displayInfo() {
        return "Room Type: " + getRoomType() + "<br>" +
                "_".repeat(50) + "<br>" +
                "Room Number: " + getRoomNumber() + "<br>" +
                getRoomType().getInfo() + "<br>" +
                "_".repeat(50) + "<br>";
    }


    private static int getNextRoomNumber() {
        return nextRoomNumber++;
    }

    public BigDecimal getCharge() {
        return roomType.getCharge();
    }

}
