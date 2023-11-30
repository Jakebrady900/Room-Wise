package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.DoubleRoom;
import com.roomwise.Room.RoomType.FamilyRoom;
import com.roomwise.Room.RoomType.SingleRoom;
import com.roomwise.Room.RoomType.TwinRoom;
import com.roomwise.Services.RoomMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomFactory {


    private final RoomMediator roomMediator;

    @Autowired
    public RoomFactory(RoomMediator roomMediator) {
        this.roomMediator = roomMediator;
    }


    // Factory method to create different types of rooms based on roomType
    public Room createRoom(String request) {
        if (request.equalsIgnoreCase("Single")) {
            return new Room(new SingleRoom(roomMediator));
        } else if (request.equalsIgnoreCase("Double")) {
            return new Room(new DoubleRoom(roomMediator));
        } else if (request.equalsIgnoreCase("Twin")) {
            return new Room(new TwinRoom(roomMediator));
        } else if (request.equalsIgnoreCase("Family")) {
            return new Room(new FamilyRoom(roomMediator));
        } else {
            return null; // Handle unsupported room types
        }
    }
}
