package com.roomwise.Services;

import com.roomwise.Repositories.RoomDAO;
import com.roomwise.Models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    /**
     * The RoomService class is used to house the main buisness logic of the application.
     * It is used to handle the data that is passed to and from the database (List in this case).
     * It is used by the ReservationService class to generate reservations.
     */

    private final RoomDAO roomRepository;

    @Autowired
    public RoomService(RoomDAO roomRepository) {
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

    public void updateRoom(Room room, int id){
        roomRepository.updateRoom(room, id);
    }

    public void deleteRoom(int roomNumber){
        roomRepository.deleteRoom(roomNumber);
    }

}
