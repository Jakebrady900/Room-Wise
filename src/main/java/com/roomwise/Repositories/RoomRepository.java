package com.roomwise.Repositories;


import com.roomwise.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {
    List<Room> RoomDB = new ArrayList<>();

    public void save(Room room) {
        RoomDB.add(room);
    }

    public List<Room> getRooms() {
        return RoomDB;
    }

    public Room getRoom(int roomNumber){
        for (Room room : RoomDB) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void deleteRoom(int roomNumber){
        RoomDB.remove(roomNumber);
    }


}
