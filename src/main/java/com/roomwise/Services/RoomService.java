package com.roomwise.Services;

import com.roomwise.Repositories.RoomRepository;
import com.roomwise.Models.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms(){
        return roomRepository.getRooms();
    }

    public Room getRoom(int id){
        return roomRepository.getRoom(id);
    }

    public void addRoom(Room room){
        roomRepository.addRoom(room);
    }

    public void updateRoom(Room room, int id){
        roomRepository.updateRoom(room, id);
    }

    public void deleteRoom(int id){
        roomRepository.deleteRoom(id);
    }

}
