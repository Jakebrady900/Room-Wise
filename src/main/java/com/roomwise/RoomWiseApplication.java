package com.roomwise;

import com.roomwise.Factories.DoubleRoom;
import com.roomwise.Factories.FamilyRoom;
import com.roomwise.Factories.SingleRoom;
import com.roomwise.Factories.TwinRoom;
import com.roomwise.Models.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RoomWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomWiseApplication.class, args);
    }

    @GetMapping("/")
    public String WelcomeMessage() {
        return "Welcome to Room-Wise!";
    }


}
