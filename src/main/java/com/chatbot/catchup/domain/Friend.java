package com.chatbot.catchup.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "friends")
public class Friend {

    @EmbeddedId
    private FriendId id;  // Composite primary key (user_id, friend_id)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FriendStatus status;

}
