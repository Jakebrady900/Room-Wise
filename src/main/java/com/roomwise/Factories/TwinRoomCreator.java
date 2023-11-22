package com.roomwise.Factories;

import com.roomwise.Models.Room;

public class TwinRoomCreator implements RoomFactory {
    @Override
    public Room createRoom() {
        return new TwinRoom(1);
    }
}
