package com.chatbot.catchup.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private String sender;

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}
