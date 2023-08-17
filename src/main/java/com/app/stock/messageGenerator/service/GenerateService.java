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

    public List<Agent> createAgents(Integer numberOfAgents, List<TelemetryMessage> messageList) {
        log.info("begin createAgents()");
        List<Agent> agentsList = new ArrayList<>();
        for (int i = 0; i <= numberOfAgents; i++) {
            Gadget gadget = Gadget.getRandom();
            messageList.forEach(x -> x.setAgentId(gadget));
            agentsList.add(Agent.builder()
                    .agentId(gadget)
                    .manufacturer(Manufacturer.getRandom())
                    .os(OS.getRandom())
                    .messageEntities(messageList)
                    .build());
        }
        log.info(agentsList.size() + " - agents have created");
        return agentsList;
    }

    public List<TelemetryMessage> createTelemetryMessages(Integer numberOfMessagesPerMinute) {
        log.info("begin createTelemetryMessages()");
        Random random = new Random();
        List<TelemetryMessage> telemetryMessageList = new ArrayList<>();
        for (int i = 0; i <= numberOfMessagesPerMinute; i++) {
            telemetryMessageList.add(TelemetryMessage.builder()
                    .UUID(UUID.randomUUID().toString())
                    .agentId(Gadget.getRandom())
                    .previousMessageTime(generateUnixTimestampPerWeek())
                    .activeService(ActiveService.getRandom())
                    .qualityScore(random.nextInt(1, 101))
                    .build());
        }
        log.info(telemetryMessageList.size() + " - telemetry messages have created");
        return telemetryMessageList;
    }

    public Long generateUnixTimestampPerWeek() {
        long currentTimestamp = Instant.now().getEpochSecond();
        long oneWeekAgoTimestamp = currentTimestamp - (7 * 24 * 60 * 60);
        return (long) (Math.random() * (currentTimestamp - oneWeekAgoTimestamp)) + oneWeekAgoTimestamp;
    }
}
