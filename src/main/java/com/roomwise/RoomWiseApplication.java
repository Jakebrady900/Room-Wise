package com.roomwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RoomWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomWiseApplication.class, args);
    }

    @GetMapping("/")
    public String WelcomeMessage() {
        return "Welcome to Room-Wise!";
    }

}
