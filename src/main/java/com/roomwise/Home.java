package com.roomwise;

// import org.springframework.web.bind.annotation.GetMapping;
import com.roomwise.Models.Room;
import com.roomwise.Room.Factories.RoomFactory;
import com.roomwise.Room.Factories.SingleRoomCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Home {
    @RequestMapping("/home")
    public String WelcomeMessage() {
        return "Welcome to Room-Wise!";
    }

}
