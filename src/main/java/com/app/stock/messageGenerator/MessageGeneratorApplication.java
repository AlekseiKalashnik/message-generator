package com.app.stock.messageGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MessageGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageGeneratorApplication.class, args);
    }
}
