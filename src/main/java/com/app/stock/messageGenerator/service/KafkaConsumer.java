//package com.app.stock.messageGenerator.service;
//
//import com.app.stock.messageGenerator.entity.TelemetryMessage;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.common.protocol.types.Field;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.CountDownLatch;
//
//@Slf4j
//@Getter
//@Service
//@RequiredArgsConstructor
//public class KafkaConsumer {
//
//    private String payload;
//
//    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
//    public void getMessageFromTopic(TelemetryMessage message) {
//        log.info("kafka message consumed='{}'", message.toString());
//        payload = message.toString();
//    }
//}
