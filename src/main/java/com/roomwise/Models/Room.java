package com.roomwise.Models;


import com.roomwise.Room.RoomType.RoomType;

public class Room {

    private Long id;
    private Integer roomNumber;
    private final RoomType _roomType;

    public Room(RoomType roomType, Integer roomNumber) {
        setRoomNumber(roomNumber);
        _roomType = roomType;
    }

    public String displayInfo() {
        return "Room Type: " + getRoomType() + "<br>" +
                "_".repeat(50) + "<br>" +
                "Room Number: " + getRoomNumber() + "<br>" +
                _roomType.getInfo() + "<br>" +
                "_".repeat(50) + "<br>";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return _roomType.getClass().getSimpleName();
    }
}
