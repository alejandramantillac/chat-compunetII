package com.icesi.chatback.controllers;

import java.security.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.icesi.chatback.model.Chat;
import com.icesi.chatback.model.Message;
import com.icesi.chatback.services.ChatService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService service;

    @PostMapping("path")
    public ResponseEntity <?> postMethodName(
            @RequestBody Message entity, @ModelAttribute Chat chat) {

        service.sendMessage(chat.getFrom(), chat.getDest(), entity);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getChat(@ModelAttribute Chat chat) {
        return ResponseEntity.ok(service.getChat(chat.getFrom(), chat.getDest()));
    }
    
    
}
