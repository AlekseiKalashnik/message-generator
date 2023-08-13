package com.app.stock.messageGenerator.job;

import com.app.stock.messageGenerator.entity.Agent;
import com.app.stock.messageGenerator.entity.TelemetryMessage;
import com.app.stock.messageGenerator.service.GenerateService;
import com.app.stock.messageGenerator.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessMessage {
    @Value(value = "${number_of_agents}")
    private int numberOfAgents;
    @Value(value = "${number_of_messages_per_minute}")
    private int messagesPerMinute;
    private final KafkaProducer kafkaProducer;
    private final GenerateService generateService;

    @Async
    public CompletableFuture<Void> sendMessages() {
        log.info("begin sendMessages()");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<TelemetryMessage> messages = generateService.createTelemetryMessages(messagesPerMinute);
                List<Agent> agents = generateService.createAgents(numberOfAgents, messages);
                kafkaProducer.sendMessageToTopic(agents);
            }
        };
        timer.scheduleAtFixedRate(task, 60000, messagesPerMinute);
        return null;
    }
}
