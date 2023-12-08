package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.SingleRoom;

public class SingleRoomFactory extends RoomFactory {

    public Room doCreate() {
        return new Room(new SingleRoom());
    }
}
