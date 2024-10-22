package com.icesi.chatback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icesi.chatback.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
    
}
