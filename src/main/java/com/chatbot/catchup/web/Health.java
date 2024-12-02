package com.chatbot.catchup.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {

    @GetMapping("/health")
    public String healthStatus() {
        return "Health status is working fine";
    }
}
