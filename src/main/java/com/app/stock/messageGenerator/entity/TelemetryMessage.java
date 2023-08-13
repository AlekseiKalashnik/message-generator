package com.app.stock.messageGenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown=true)
public class TelemetryMessage {
    @JsonProperty(value = "uuid")
    String UUID;
    @JsonProperty(value = "agent_id")
    Gadget agentId;
    @JsonProperty(value = "previous_message_time")
    Long previousMessageTime;
    @JsonProperty(value = "active_service")
    ActiveService activeService;
    @JsonProperty(value = "quality_score")
    Integer qualityScore;
}
