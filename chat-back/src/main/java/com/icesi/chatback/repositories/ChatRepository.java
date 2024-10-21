package com.icesi.chatback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icesi.chatback.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    
    Optional <Chat> findByFromAndDest(String from, String dest);
}
