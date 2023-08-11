package com.app.stock.messageGenerator.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {
    private final KafkaProperties kafkaProperties;

    //TODO Change entity
//    @Bean
//    public ProducerFactory<String, UserDTO> producerFactory() {
//        Map<String, Object> properties = kafkaProperties.buildProducerProperties();
//        return new DefaultKafkaProducerFactory<>(properties);
//    }
//
//    //TODO Change entity
//    @Bean
//    public KafkaTemplate<String, UserDTO> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean
//    public NewTopic topic() {
//        return TopicBuilder
//                .name("topic-1")
//                .build();
//    }
}
