package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.RoomType;
import com.roomwise.Room.RoomType.SingleRoom;

public class SingleRoomCreator implements RoomFactory {

    public SingleRoomCreator() {
    }

    public Room createRoom() {
        return new Room(new SingleRoom(), 1);
    }
}
