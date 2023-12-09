package com.roomwise.Factories;

import com.roomwise.Models.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomFactory {
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

    // This method is overridden by the concrete factories.
    // It is considered the factory method.
    public Room doCreate() {
        return null;
    }

}
