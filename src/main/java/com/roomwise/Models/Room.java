package com.roomwise.Models;


import com.roomwise.Room.RoomType.RoomType;
import com.roomwise.Services.IdService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@Component
public class Room {

    private String id;
    private Integer roomNumber;
    private RoomType roomType;

    public Room(RoomType roomType) {
        id = UUID.randomUUID().toString();
        this.roomNumber = IdService.getNextRoomNumber();
        setRoomType(roomType);
    }

    public String displayInfo() {
        return "Room Type: " + getRoomType() + "<br>" +
                "_".repeat(50) + "<br>" +
                "Room Number: " + getRoomNumber() + "<br>" +
                getRoomType().getInfo() + "<br>" +
                "_".repeat(50) + "<br>";
    }



    public BigDecimal getCharge() {
        return roomType.getCharge();
    }

}
