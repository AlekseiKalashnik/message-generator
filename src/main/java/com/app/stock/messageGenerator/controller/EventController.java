package com.app.stock.messageGenerator.controller;

import com.app.stock.messageGenerator.job.ProcessMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/send")
public class EventController {
    private final ProcessMessage processMessage;

    @GetMapping("/{numberOfAgents}/{messagesPerMinute}")
    public String createMessages(@PathVariable Integer numberOfAgents, @PathVariable Integer messagesPerMinute) {
        processMessage.sendMessages(numberOfAgents, messagesPerMinute);
        log.info("messages have sent");
        return "Start to send messages...";
    }
}
