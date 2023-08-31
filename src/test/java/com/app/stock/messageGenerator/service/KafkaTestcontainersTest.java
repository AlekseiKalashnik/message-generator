//package com.app.stock.messageGenerator.service;
//
//import com.app.stock.messageGenerator.entity.Gadget;
//import com.app.stock.messageGenerator.entity.TelemetryMessage;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//import java.util.UUID;
//
//@SpringBootTest
//@Testcontainers
//class KafkaTestcontainersTest {
//
//    @Container
//    static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.3.3"));
//
//    @DynamicPropertySource
//    static void overrideProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
//    }
//
//    @Autowired
//    KafkaTemplate<String, TelemetryMessage> kafkaTemplate;
//
//    @Autowired
//    KafkaConsumer consumer;
//
//    @Value("${topic.name}")
//    private String topic;
//
//    //before test run docker-compose file
//    @Test
//    void testProduceAndConsumeKafkaMessage() {
//        TelemetryMessage message = TelemetryMessage.builder()
//                .UUID(UUID.randomUUID().toString())
//                .agentId(Gadget.getRandom())
//                .build();
//
//        kafkaTemplate.send(topic, message);
//
//        consumer.getMessageFromTopic(message);
//
//        Assertions.assertEquals(consumer.getPayload(), message.toString());
//    }
//}
