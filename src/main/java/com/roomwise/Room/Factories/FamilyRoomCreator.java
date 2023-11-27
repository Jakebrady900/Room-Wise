package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.FamilyRoom;

public class FamilyRoomCreator implements RoomFactory {

    public FamilyRoomCreator() {
    }

    public Room createRoom() {
        return new Room(new FamilyRoom(), 4);
    }
}
