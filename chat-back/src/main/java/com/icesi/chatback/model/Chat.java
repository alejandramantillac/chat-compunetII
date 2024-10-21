package com.icesi.chatback.model;

import java.util.List;
import com.icesi.chatback.model.Message;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chat")
public class Chat {
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String from;
    private String dest;

    @OneToMany(mappedBy = "chat")
    List<Message> messages;
}
