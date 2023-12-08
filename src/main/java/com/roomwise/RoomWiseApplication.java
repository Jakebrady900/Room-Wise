package com.roomwise;


import com.roomwise.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class RoomWiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomWiseApplication.class, args);
    }

}
