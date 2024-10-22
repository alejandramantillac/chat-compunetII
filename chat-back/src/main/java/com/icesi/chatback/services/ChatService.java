package com.icesi.chatback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.icesi.chatback.model.Chat;
import com.icesi.chatback.model.Message;
import com.icesi.chatback.repositories.ChatRepository;
import com.icesi.chatback.repositories.MessageRepository;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    public void sendMessage(String from, String dest, Message message) {
        Chat chat = getChat(from, dest);

        chatRepository.save(chat);
        message.setChat(chat);
        messageRepository.save(message);
    }

    public Chat getChat(String from, String dest) {
        return chatRepository.findByFromAndDest(from, dest).orElse(
            Chat.builder()
                .from(from)
                .dest(dest)
                .build()
        );
    }
}