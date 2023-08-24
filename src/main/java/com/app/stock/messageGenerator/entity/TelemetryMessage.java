package com.app.stock.messageGenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryMessage {
    @JsonProperty(value = "uuid")
    private String UUID;
    @JsonProperty(value = "agent_id")
    private Gadget agentId;
    @JsonProperty(value = "previous_message_time")
    private Long previousMessageTime;
    @JsonProperty(value = "active_service")
    private ActiveService activeService;
    @JsonProperty(value = "quality_score")
    private Integer qualityScore;
    @JsonProperty(value = "agents")
    private List<Agent> agents;
}
