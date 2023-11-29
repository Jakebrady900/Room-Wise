package com.roomwise.Room.Factories;

import com.roomwise.Models.Room;
import com.roomwise.Room.Mediator.RoomMediator;
import com.roomwise.Room.RoomType.DoubleRoom;
import com.roomwise.Room.RoomType.SingleRoom;
import com.roomwise.Room.RoomType.TwinRoom;
import com.roomwise.Services.RoomService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class TwinRoomCreator implements RoomFactory {

    private RoomMediator roomMediator;

    @Autowired
    public TwinRoomCreator(RoomMediator roomMediator) {
        this.roomMediator = roomMediator;
    }

    public Room createRoom() {
        return new Room(new DoubleRoom());
    }
}
