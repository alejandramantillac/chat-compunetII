package com.icesi.chatback.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String type;
    private String content;
    private boolean isRead;
    private long date;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;
}