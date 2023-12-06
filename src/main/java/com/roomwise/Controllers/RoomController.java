package com.roomwise.Controllers;


import com.roomwise.Services.RoomService;
import com.roomwise.Models.Room;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/room-wise/")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @RequestMapping("/rooms")
    public List<Room> getRooms(){
        return roomService.getRooms();
    }

    @RequestMapping("/room/{roomNumber}")
    public Room getRoom(@PathVariable("roomNumber") int roomNumber){
        return roomService.getRoom(roomNumber);
    }

    public void addRoom(Room room){
        roomService.addRoom(room);
    }

    public void updateRoom(Room room, int id){
        roomService.updateRoom(room, id);
    }

    @DeleteMapping("/remove-room/{roomNumber}")
    public void deleteRoom(@PathVariable("roomNumber") int roomNumber){
        roomService.deleteRoom(roomNumber);
    }

}
