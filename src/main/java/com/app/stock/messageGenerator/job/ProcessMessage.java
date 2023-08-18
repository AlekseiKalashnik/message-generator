package com.app.stock.messageGenerator.job;

import com.app.stock.messageGenerator.entity.Agent;
import com.app.stock.messageGenerator.entity.TelemetryMessage;
import com.app.stock.messageGenerator.service.GenerateService;
import com.app.stock.messageGenerator.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessMessage {
    private final KafkaProducer kafkaProducer;
    private final GenerateService generateService;

    @Async
    public void sendMessages(int numberOfAgents, int messagesPerMinute) {
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
    }
}
