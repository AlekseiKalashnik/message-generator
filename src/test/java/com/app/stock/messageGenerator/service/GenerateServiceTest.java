package com.app.stock.messageGenerator.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class GenerateServiceTest {
    private GenerateService generateService;

    @BeforeEach
    void prepare() {
        log.info("Before each " + this);
        generateService = new GenerateService();
    }

    @Test
    void agentsSizeIfOneAgentAdded() {
        var agents = generateService.createAgents(1);
        assertEquals(1, agents.size());
    }

    @Test
    void agentsEmptyIfNoAgentAdded() {
        var agents = generateService.createAgents(0);
        assertTrue(agents.isEmpty());
    }

    @Test
    void methodRandomGenerateDifferentAgents() {
        var agents = generateService.createAgents(100);
        int uniqueElementsSize = agents.stream().distinct().toList().size();
        assertEquals(agents.size(), uniqueElementsSize);
    }

    @Test
    void telemetryMessageIfOneAgentAdded() {
        var agents = generateService.createAgents(1);
        var message = generateService.createTelemetryMessage(agents);
        assertEquals(1, message.getAgents().size());
    }

    @Test
    void telemetryMessageIfNoAgentAdded() {
        var agents = generateService.createAgents(0);
        var message = generateService.createTelemetryMessage(agents);
        assertTrue(message.getAgents().isEmpty());
    }
}