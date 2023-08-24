package com.app.stock.messageGenerator.job;

import com.app.stock.messageGenerator.dto.RequestDTO;
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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessMessage {
    private final KafkaProducer kafkaProducer;
    private final GenerateService generateService;

    @Async
    public void sendMessages(RequestDTO requestDTO) {
        log.info("begin sendMessages()");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                List<Agent> agents = generateService.createAgents(requestDTO.numberOfAgents());
                TelemetryMessage message = generateService.createTelemetryMessage(agents);
                kafkaProducer.sendMessageToTopic(message);
            }
        };
        timer.scheduleAtFixedRate(task, 60000, requestDTO.messagesPerMinute() * 1000L);
    }
}
