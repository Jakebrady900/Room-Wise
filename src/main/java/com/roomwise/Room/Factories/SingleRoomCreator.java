package com.roomwise.Room.Factories;

import com.roomwise.Controllers.RoomController;
import com.roomwise.Models.Room;
import com.roomwise.Room.Mediator.Mediator;
import com.roomwise.Room.Mediator.RoomMediator;
import com.roomwise.Room.RoomType.SingleRoom;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SingleRoomCreator implements RoomFactory {

    @Autowired
    private RoomMediator roomMediator;


    public Room createRoom() {
        return new Room(new SingleRoom(roomMediator));
    }
}
