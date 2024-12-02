package com.chatbot.catchup.services;

import com.chatbot.catchup.domain.Message;
import com.chatbot.catchup.domain.User;
import com.chatbot.catchup.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message addUserToSession(Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        messageRepository.save(message);
        return message;
    }
}
