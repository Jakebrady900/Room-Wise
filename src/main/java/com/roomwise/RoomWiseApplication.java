package com.roomwise;

import com.roomwise.Models.Room;
import com.roomwise.Room.Factories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RoomWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomWiseApplication.class, args);
    }

}
