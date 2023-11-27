package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.SingleRoom;
import com.roomwise.Room.RoomType.TwinRoom;

public class TwinRoomCreator implements RoomFactory {

    public TwinRoomCreator() {
    }

    public Room createRoom() {
        return new Room(new TwinRoom(), 2);
    }

}
