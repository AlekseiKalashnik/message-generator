package com.app.stock.messageGenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class MessageEntity {
    @JsonProperty(value = "uuid")
    String UUID;
    @JsonProperty(value = "agent_id")
    String agentId;
    @JsonProperty(value = "previous_message_time")
    Long previousMessageTime;
    @JsonProperty(value = "active_service")
    String activeService;
    @JsonProperty(value = "quality_score")
    Integer qualityScore;
}
