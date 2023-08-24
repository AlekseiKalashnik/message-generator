package com.app.stock.messageGenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {
    @JsonProperty(value = "agent_id")
    private Gadget agentId;
    private Manufacturer manufacturer;
    private OS os;
}
