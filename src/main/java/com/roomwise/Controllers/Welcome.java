package com.roomwise.Controllers;

import com.roomwise.Models.Room;
import com.roomwise.Room.Factories.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String WelcomeMessage() {
        return "Welcome to Room-Wise!";
    }

    @GetMapping("/SingleRoom")
    public String SingleRoomTest() {
        RoomFactory rf = new SingleRoomCreator();
        Room singleRoom = rf.createRoom();
        return singleRoom.displayInfo();
    }
    @GetMapping("/TwinRoom")
    public String TwinRoomTest() {
        RoomFactory rf = new TwinRoomCreator();
        Room twinRoom = rf.createRoom();
        return twinRoom.displayInfo();
    }
    @GetMapping("/DoubleRoom")
    public String DoubleRoomTest() {
        RoomFactory rf = new DoubleRoomCreator();
        Room doubleRoom = rf.createRoom();
        return doubleRoom.displayInfo();
    }
    @GetMapping("/FamilyRoom")
    public String FamilyRoomTest() {
        RoomFactory rf = new FamilyRoomCreator();
        Room familyRoom = rf.createRoom();
        return familyRoom.displayInfo();
    }
}
