package com.roomwise.Factories;

import com.roomwise.Models.Room;

public class DoubleRoomCreator implements RoomFactory {
    @Override
    public Room createRoom() {
        return new DoubleRoom(1);
    }
}
