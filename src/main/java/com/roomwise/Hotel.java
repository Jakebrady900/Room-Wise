package com.roomwise;

import com.roomwise.Controllers.RoomController;
import com.roomwise.Room.Factories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
    private final SingleRoomCreator singleRoomFactory;
    private final DoubleRoomCreator doubleRoomFactory;
    private final TwinRoomCreator twinRoomFactory;
    private final FamilyRoomCreator familyRoomFactory;
    private final RoomController roomController;

    @Autowired
    public Hotel(SingleRoomCreator singleRoomFactory,
                 DoubleRoomCreator doubleRoomFactory,
                 TwinRoomCreator twinRoomFactory,
                 FamilyRoomCreator familyRoomFactory,
                 RoomController roomController) {
        this.singleRoomFactory = singleRoomFactory;
        this.doubleRoomFactory = doubleRoomFactory;
        this.twinRoomFactory = twinRoomFactory;
        this.familyRoomFactory = familyRoomFactory;
        this.roomController = roomController;
    }

    @PostConstruct
    public void onInit() {
        System.out.println("Hotel created");
        //initiateHotel();
        System.out.println("Rooms created");
    }

    public void initiateHotel() {
        roomController.addRoom(singleRoomFactory.createRoom());
//        roomController.addRoom(doubleRoomFactory.createRoom());
//        roomController.addRoom(twinRoomFactory.createRoom());
//        roomController.addRoom(familyRoomFactory.createRoom());
    }
}


