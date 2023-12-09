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

    /**
     * Room class is the data model for a room in a hotel managed by the Room-Wise application.
     * It holds information about the room, and is composed by a RoomType object, which itself is composed of a
     *          RoomClassification object.
     * The Room class is the client in the Bridge Design pattern. The bridge pattern is used to decouple the RoomType
     *         and RoomClassification classes, allowing them to vary independently.
     */

    private String id;
    private Integer roomNumber;
    private RoomType roomType;

    public Room(RoomType roomType) {
        id = UUID.randomUUID().toString(); // Generate a random ID for the room
        this.roomNumber = IdService.getNextRoomNumber();
        setRoomType(roomType);
    }

    public String displayInfo() {
        return "Room Type: " + getRoomType().getClass().getSimpleName() + "<br>" +
                "_".repeat(50) + "<br>" +
                "Room Number: " + getRoomNumber() + "<br>" +
                getRoomType().getInfo() + "<br>" +
                "_".repeat(50) + "<br>";
    }



    public BigDecimal getCharge() {
        return roomType.getCharge();
    }

}
