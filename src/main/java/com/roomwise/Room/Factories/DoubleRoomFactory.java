package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.DoubleRoom;

public class DoubleRoomFactory extends RoomFactory {

    public Room doCreate() {
        return new Room(new DoubleRoom());
    }
}
