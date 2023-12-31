package com.roomwise.Repositories;


import com.roomwise.Models.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDAO {
    /**
     * The RoomDAO is the Data Access Object for the Room entity, also called the Repository.
     * It is used to store the data (a List in this case), usually a database is used.
     * It handles the data manipulation requests coming from the RoomService class.
     * No business logic is present in this class.
     */

    private final List<Room> RoomDB = new ArrayList<>();
    //CRUD

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

    public void updateRoom(Room updatedRoom, int roomNumber) {
        for (Room room : RoomDB) {
            if (room.getRoomNumber() == roomNumber) {
                String temp_ID =  room.getId();
                deleteRoom(roomNumber);
                updatedRoom.setRoomNumber(roomNumber);
                updatedRoom.setId(temp_ID);
                save(updatedRoom);
            }
        }
    }

    public void deleteRoom(int roomNumber){
        RoomDB.remove(roomNumber);
    }


}
