package com.chatbot.catchup.domain;

import jakarta.persistence.Column;

import java.io.Serializable;

public class FriendId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "friend_id")
    private Long friendId;

}
