package com.roomwise.Factories;

import com.roomwise.Models.Room;

public class SingleRoomCreator implements RoomFactory {
    @Override
    public Room createRoom() {
        return new SingleRoom(1);
    }

    //Should the upgradeRoom() method be returning a Room object instantiated here?

}
