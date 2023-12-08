package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.TwinRoom;

public class TwinRoomFactory extends RoomFactory {

    public Room doCreate() {
        return new Room(new TwinRoom());
    }
}
