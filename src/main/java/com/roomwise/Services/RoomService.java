package com.roomwise.Services;

import com.roomwise.Repositories.RoomRepository;
import com.roomwise.Models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public List<Room> getRooms(){
        return roomRepository.getRooms();
    }

    public Room getRoom(int roomNumber){
        return roomRepository.getRoom(roomNumber);
    }

    public void addRoom(Room room){
        roomRepository.save(room);
    }

//    public void updateRoom(Room room, int id){
//        roomRepository.updateRoom(room, id);
//    }

    public void deleteRoom(int roomNumber){
        roomRepository.deleteRoom(roomNumber);
    }
}
