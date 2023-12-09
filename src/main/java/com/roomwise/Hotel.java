package com.roomwise;

import com.roomwise.Controllers.RoomController;
import com.roomwise.Factories.RoomFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
    /**
     * This class is responsible for instantiating some rooms and adding them to the DB on startup.
     * It creates one of each room type to allow for reservations be created against those rooms.
     */

    private final RoomFactory roomFactory;
    private final RoomController roomController;

    public Hotel(RoomFactory roomFactory, RoomController roomController) {
        this.roomFactory = roomFactory;
        this.roomController = roomController;
    }

    @PostConstruct
    public void onInit()
    {
        initiateHotel();
    }

    public void initiateHotel() {
        System.out.println("Creating rooms");
        roomController.addRoom(roomFactory.createRoom("Single"));
        roomController.addRoom(roomFactory.createRoom("Twin"));
        roomController.addRoom(roomFactory.createRoom("Double"));
        roomController.addRoom(roomFactory.createRoom("Family"));
        System.out.println("Rooms Created");
    }

}


