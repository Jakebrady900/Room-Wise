package com.roomwise.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.SingleRoom;

class SingleRoomFactory extends RoomFactory {

    protected Room doCreate() {
        return new Room(new SingleRoom());
    }
}
