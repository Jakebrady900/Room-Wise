package com.roomwise.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.FamilyRoom;

class FamilyRoomFactory extends RoomFactory {

    protected Room doCreate() {
        return new Room(new FamilyRoom());
    }

}
