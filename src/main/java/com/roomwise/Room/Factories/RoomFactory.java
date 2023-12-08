package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.DoubleRoom;
import com.roomwise.Room.RoomType.FamilyRoom;
import com.roomwise.Room.RoomType.SingleRoom;
import com.roomwise.Room.RoomType.TwinRoom;
import org.springframework.stereotype.Component;

@Component
public abstract class RoomFactory {
    /**
     * This factory class implements the Factory Pattern, improving dependency management by centralising object creation.
     * It promotes code scalability, flexibility, and maintenance by isolating object creation logic from client code.
     * Through this pattern, it enables easy extension and modification, creating a more modular and manageable codebase.
     */

    public Room createRoom(String request) {
        if (request.equalsIgnoreCase("Single")) {
            return new SingleRoomFactory().doCreate();
        } else if (request.equalsIgnoreCase("Double")) {
            return new TwinRoomFactory().doCreate();
        } else if (request.equalsIgnoreCase("Twin")) {
            return new DoubleRoomFactory().doCreate();
        } else if (request.equalsIgnoreCase("Family")) {
            return new FamilyRoomFactory().doCreate();
        } else {
            return null; // Handle unsupported room types
        }
    }

    public abstract Room doCreate();
}
