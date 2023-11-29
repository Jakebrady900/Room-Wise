package com.roomwise.Models;


import com.roomwise.Room.RoomType.RoomType;
import com.roomwise.Services.RoomService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer roomNumber;
    @Embedded
    private RoomType roomType;

    public Room(RoomType roomType) {
        setRoomType(roomType);
    }

    public String displayInfo() {
        return "Room Type: " + getRoomType() + "<br>" +
                "_".repeat(50) + "<br>" +
                "Room Number: " + getRoomNumber() + "<br>" +
                getRoomType().getInfo() + "<br>" +
                "_".repeat(50) + "<br>";
    }

}
