package com.app.stock.messageGenerator.controller;

import com.app.stock.messageGenerator.entity.Agent;
import com.app.stock.messageGenerator.job.ProcessMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class EventController {
    private final ProcessMessage processMessage;

    @GetMapping("/send/{numberOfAgents}/{messagesPerMinute}")
    public void createMessages(@PathVariable Integer numberOfAgents, @PathVariable Integer messagesPerMinute) {
        processMessage.sendMessages(numberOfAgents, messagesPerMinute);
    }
}
