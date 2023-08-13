package com.app.stock.messageGenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown=true)
public class Agent {
    @JsonProperty(value = "agent_id")
    private Gadget agentId;
    private Manufacturer manufacturer;
    private OS os;
    @JsonProperty(value = "message_entities")
    private List<TelemetryMessage> messageEntities;
}
