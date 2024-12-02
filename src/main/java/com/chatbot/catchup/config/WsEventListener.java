package com.chatbot.catchup.config;

import com.chatbot.catchup.domain.Message;
import com.chatbot.catchup.domain.Type;
import com.chatbot.catchup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WsEventListener {

    private final SimpMessageSendingOperations messageSendingOperations;
    private final UserRepository userRepository;



    @EventListener
    public void hadnleDisconnectListener(SessionConnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor
                .getSessionAttributes()
                .get("username");

        if(username != null) {
            var message = Message.builder()
                    .type(Type.LEAVE)
                    .sender(username)
                    .build();
            messageSendingOperations.convertAndSend("/topic/public", message);
        }
    }
}
