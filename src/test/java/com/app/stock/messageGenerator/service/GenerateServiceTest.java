//package com.app.stock.messageGenerator.service;
//
//import com.app.stock.messageGenerator.entity.Agent;
//import com.app.stock.messageGenerator.entity.Manufacturer;
//import com.app.stock.messageGenerator.entity.OS;
//import com.app.stock.messageGenerator.entity.TelemetryMessage;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Slf4j
//@SpringBootTest
//@ExtendWith(
//        MockitoExtension.class
//)
//class GenerateServiceTest {
//    @Mock
//    private GenerateService generateService;
//
//    @BeforeEach
//    void prepare() {
//        log.info("Before each " + this);
//    }
//
//    @Test
//    void agentsSizeIfOneAgentAdded() {
//        Mockito.when(generateService.createAgents(1))
//                .thenReturn(List.of(
//                        Agent.builder().manufacturer(Manufacturer.getRandom()).build()));
//        var expectedListSize = generateService.createAgents(1).size();
//        assertEquals(1, expectedListSize);
//    }
//
//    @Test
//    void agentsEmptyIfNoAgentAdded() {
//        var agents = generateService.createAgents(0);
//        assertTrue(agents.isEmpty());
//    }
//
//    @Test
//    void methodRandomGenerateDifferentAgents() {
//        var agents = generateService.createAgents(55);
//        int uniqueElementsSize = agents.stream().distinct().toList().size();
//        assertEquals(agents.size(), uniqueElementsSize);
//    }
//
//    @Test
//    void telemetryMessageIfOneAgentAdded() {
//        var agentList = List.of(
//                Agent.builder().os(OS.getRandom()).build(),
//                Agent.builder().manufacturer(Manufacturer.getRandom()).build());
//
//        Mockito.when(generateService.createTelemetryMessage(agentList))
//                .thenReturn(TelemetryMessage.builder().agents(agentList).build());
//
//        var expectedSize = generateService.createTelemetryMessage(agentList).getAgents().size();
//        assertEquals(2, expectedSize);
//    }
//
//    @Test
//    void telemetryMessageIfNoAgentAdded() {
//        var agents = generateService.createAgents(0);
//        var message = generateService.createTelemetryMessage(agents);
//        assertNull(message);
//    }
//}