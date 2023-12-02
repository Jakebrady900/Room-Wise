package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.DoubleRoom;
import com.roomwise.Room.RoomType.FamilyRoom;
import com.roomwise.Room.RoomType.SingleRoom;
import com.roomwise.Room.RoomType.TwinRoom;
import org.springframework.stereotype.Component;

@Component
public class RoomFactory {


    // Factory method to create different types of rooms based on roomType
    public Room createRoom(String request) {
        if (request.equalsIgnoreCase("Single")) {
            return new Room(new SingleRoom());
        } else if (request.equalsIgnoreCase("Double")) {
            return new Room(new DoubleRoom());
        } else if (request.equalsIgnoreCase("Twin")) {
            return new Room(new TwinRoom());
        } else if (request.equalsIgnoreCase("Family")) {
            return new Room(new FamilyRoom());
        } else {
            return null; // Handle unsupported room types
        }
    }
}
