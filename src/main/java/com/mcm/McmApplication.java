package com.mcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class McmApplication {
    public static void main(String[] args) {
        SpringApplication.run(McmApplication.class, args);
    }
}

