package com.roomwise.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.RoomType.FamilyRoom;

public class FamilyRoomFactory extends RoomFactory {

    public Room doCreate() {
        return new Room(new FamilyRoom());
    }

}
