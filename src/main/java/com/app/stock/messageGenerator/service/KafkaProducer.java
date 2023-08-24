package com.app.stock.messageGenerator.service;

import com.app.stock.messageGenerator.entity.TelemetryMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {
    @Value("${topic.name}")
    private String topic;

    private final KafkaTemplate<String, TelemetryMessage> kafkaTemplate;

    public void sendMessageToTopic(TelemetryMessage message) {
        kafkaTemplate.send(topic, message);
        log.info("kafka message produced");
    }
}
