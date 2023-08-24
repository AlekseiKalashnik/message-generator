package com.app.stock.messageGenerator.controller;

import com.app.stock.messageGenerator.dto.RequestDTO;
import com.app.stock.messageGenerator.job.ProcessMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/events")
public class EventController {
    private final ProcessMessage processMessage;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> createMessages(@RequestBody RequestDTO requestDTO) {
        processMessage.sendMessages(requestDTO);
        log.info("messages have sent");
        return Mono.just("Start to send messages...");
    }
}
