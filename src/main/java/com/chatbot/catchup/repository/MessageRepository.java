package com.chatbot.catchup.repository;

import com.chatbot.catchup.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
