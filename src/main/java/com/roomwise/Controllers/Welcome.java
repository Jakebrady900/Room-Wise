package com.roomwise.Controllers;

import com.roomwise.Models.Room;
import com.roomwise.Room.Factories.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String WelcomeMessage() {
        return "Welcome to Room-Wise!";
    }

    
}
