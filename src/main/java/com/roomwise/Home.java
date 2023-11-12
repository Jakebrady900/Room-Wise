package com.roomwise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/Home")
    public String WelcomeMessage() {
        return "Welcome to Room-Wise!";
    }
}
