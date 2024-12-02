package com.chatbot.catchup.web;

import com.chatbot.catchup.domain.Message;
import com.chatbot.catchup.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MesssageEndpoint {

    private final MessageService messageService;

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUserToSession(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        return messageService.addUserToSession(message, headerAccessor);
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(Message message) {
        return messageService.sendMessage(message);
    }
}
