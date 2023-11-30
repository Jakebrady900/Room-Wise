package com.roomwise;

import com.roomwise.Controllers.RoomController;
import com.roomwise.Room.Factories.*;
import com.roomwise.Room.RoomType.Content;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Hotel {
    private final RoomFactory roomFactory;
    private final RoomController roomController;

    @Autowired
    public Hotel(RoomFactory roomFactory, RoomController roomController) {
        this.roomFactory = roomFactory;
        this.roomController = roomController;
    }

    @PostConstruct
    public void onInit() {
        initiateHotel();
    }

    public void initiateHotel() {
        System.out.println("Creating rooms");
        roomController.addRoom(roomFactory.createRoom("Single"));
        roomController.addRoom(roomFactory.createRoom("Twin"));
        roomController.addRoom(roomFactory.createRoom("Double"));
        roomController.addRoom(roomFactory.createRoom("Family"));
        System.out.println("Rooms Created");


//        System.out.println(roomController.getRoom(1).displayInfo());
//        System.out.println(roomController.getRoom(1).getCharge());
//        roomController.getRoom(1).getRoomType().addContents(List.of(Content.SingleBed, Content.Breakfast, Content.Breakfast, Content.Breakfast, Content.Breakfast));
//        System.out.println(roomController.getRoom(1).getCharge());


    }
}


