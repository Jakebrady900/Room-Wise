package com.roomwise.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.TwinRoom;

class TwinRoomFactory extends RoomFactory {

    protected Room doCreate() {
        return new Room(new TwinRoom());
    }
}
