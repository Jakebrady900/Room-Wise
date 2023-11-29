package com.roomwise.Controllers;


import com.roomwise.Services.RoomService;
import com.roomwise.Models.Room;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room-wise/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    public List<Room> getRooms(){
        return roomService.getRooms();
    }

    public Room getRoom(int id){
        return roomService.getRoom(id);
    }

    public void addRoom(Room room){
        roomService.addRoom(room);
    }

//    public void updateRoom(Room room, int id){
//        roomService.updateRoom(room, id);
//    }

    public void deleteRoom(int id){
        roomService.deleteRoom(id);
    }

}
