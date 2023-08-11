package com.app.stock.messageGenerator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Agent {
    @JsonProperty(value = "agent_id")
    private String id;
    private String manufacturer;
    private String os;
    private List<MessageEntity> messageEntityList;
}
