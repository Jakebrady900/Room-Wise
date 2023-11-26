package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.DoubleRoom;

public class DoubleRoomCreator implements RoomFactory {
    public DoubleRoomCreator() {
    }

    public Room createRoom() {
        return new Room(new DoubleRoom(), 3);
    }
}
