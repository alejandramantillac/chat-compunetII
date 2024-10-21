package com.icesi.chatback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icesi.chatback.model.Chat;

public interface MessageRepository extends JpaRepository<Chat, Long>{
    
    Optional <Chat> findByFromAndDest(String from, String dest);
}
