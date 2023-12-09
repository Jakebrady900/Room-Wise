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
    /**
     * The RoomController class is responsible for handling all the requests that are related to the Room entity.
     * It is responsible for handling the requests and sending the response back to the view...
     *      which is simulated by Postman in this case.
     * The RoomController delegates the requests to the RoomService class.
     */

    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @RequestMapping("/rooms")
    public String getRooms(){
        StringBuilder returnStr = new StringBuilder();
        List<Room> rooms = roomService.getRooms();
        for (Room room : rooms){
            returnStr.append(room.displayInfo());
        }
        return returnStr.toString();
    }

    @RequestMapping("/room/{roomNumber}")
    public String getRoom(@PathVariable("roomNumber") int roomNumber){
        return roomService.getRoom(roomNumber).displayInfo();
    }

    @PutMapping("/add-room")
    public void addRoom(@RequestBody Room room){
        roomService.addRoom(room);
    }

    @PutMapping("/update-room/{id}")
    public void updateRoom (@RequestBody Room room, @PathVariable int id){
        roomService.updateRoom(room, id);
    }

    @DeleteMapping("/remove-room/{roomNumber}")
    public void deleteRoom(@PathVariable("roomNumber") int roomNumber){
        roomService.deleteRoom(roomNumber);
    }

}
