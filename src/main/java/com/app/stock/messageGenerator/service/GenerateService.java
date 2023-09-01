package com.app.stock.messageGenerator.service;

import com.app.stock.messageGenerator.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenerateService {

    public List<Agent> createAgents(Integer numberOfAgents) {
        log.info("begin createAgents()");
        List<Agent> agentsList = new ArrayList<>();
        for (int i = 1; i <= numberOfAgents; i++) {
            Gadget gadget = Gadget.getRandom();
            agentsList.add(Agent.builder()
                    .UUID(UUID.randomUUID().toString())
                    .agentId(gadget)
                    .manufacturer(Manufacturer.getRandom())
                    .os(OS.getRandom())
                    .build());
        }
        log.info(agentsList.size() + " - agents have created");
        return agentsList;
    }

    public TelemetryMessage createTelemetryMessage(List<Agent> agentList) {
        log.info("begin createTelemetryMessages()");
        Random random = new Random();
        TelemetryMessage message = TelemetryMessage.builder()
                .UUID(UUID.randomUUID().toString())
                .agentId(Gadget.getRandom())
                .previousMessageTime(generateUnixTimestampPerWeek())
                .activeService(ActiveService.getRandom())
                .qualityScore(random.nextInt(1, 101))
                .build();
        message.setAgents(agentList.stream().peek(x -> x.setTelemetryMessage(message.getUUID())).toList());
        log.info("telemetry message has created");
        return message;
    }

    public Long generateUnixTimestampPerWeek() {
        long currentTimestamp = Instant.now().getEpochSecond();
        long oneWeekAgoTimestamp = currentTimestamp - (7 * 24 * 60 * 60);
        return (long) (Math.random() * (currentTimestamp - oneWeekAgoTimestamp)) + oneWeekAgoTimestamp;
    }
}
