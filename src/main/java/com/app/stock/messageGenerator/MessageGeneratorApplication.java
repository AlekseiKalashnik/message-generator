package com.app.stock.messageGenerator;

import com.app.stock.messageGenerator.job.ProcessMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;

@Slf4j
@EnableAsync
@EnableKafka
@SpringBootApplication
public class MessageGeneratorApplication implements CommandLineRunner {
    ProcessMessage processMessage;

    public static void main(String[] args) {
        SpringApplication.run(MessageGeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CompletableFuture<Void> completableFuture = processMessage.sendMessages();
    }
}
