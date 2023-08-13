package com.app.stock.messageGenerator.service;

import com.app.stock.messageGenerator.entity.Agent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {
    @Value("${topic.name}")
    private String topic;

    private final KafkaTemplate<String, List<Agent>> kafkaTemplate;

    public void sendMessageToTopic(List<Agent> messageList) {
        kafkaTemplate.send(topic, messageList);
        log.info("kafka message produced");
    }
}
