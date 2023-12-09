package com.roomwise.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    /**
     * This method is used to greet any user who visits the root of the API.
     */
    @GetMapping("/")
    public String WelcomeMessage() {
        return "Welcome to Room-Wise!";
    }

    
}
