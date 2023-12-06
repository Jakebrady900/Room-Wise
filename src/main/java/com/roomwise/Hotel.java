package com.roomwise;

import com.roomwise.Controllers.CustomerController;
import com.roomwise.Controllers.RoomController;
import com.roomwise.Models.Customer;
import com.roomwise.Repositories.CustomerDAO;
import com.roomwise.Room.Factories.*;
import com.roomwise.Room.RoomType.Content;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Hotel {
    private final RoomFactory roomFactory;
    private final RoomController roomController;
    private final CustomerController customerController;

    @Autowired
    public Hotel(RoomFactory roomFactory, RoomController roomController, CustomerController customerController) {
        this.roomFactory = roomFactory;
        this.roomController = roomController;
        this.customerController = customerController;
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


