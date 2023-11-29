package com.roomwise.Services;

import com.roomwise.Repositories.RoomRepository;
import com.roomwise.Models.Room;
import com.roomwise.Room.Factories.RoomFactory;
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
        return roomRepository.findAll();
    }

    public Room getRoom(int id){
        return null;
        //return roomRepository.findById(id);
    }

    public void addRoom(Room room){
        roomRepository.save(room);
    }

//    public void updateRoom(Room room, int id){
//        roomRepository.updateRoom(room, id);
//    }

    public void deleteRoom(int id){
        roomRepository.deleteById(id);
    }
}
