package com.roomwise.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.DoubleRoom;

class DoubleRoomFactory extends RoomFactory {

    protected Room doCreate() {
        return new Room(new DoubleRoom());
    }
}
