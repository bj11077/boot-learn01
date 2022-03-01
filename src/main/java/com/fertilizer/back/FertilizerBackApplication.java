package com.fertilizer.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FertilizerBackApplication {



    public static void main(String[] args) {
        SpringApplication.run(FertilizerBackApplication.class, args);
    }

}
