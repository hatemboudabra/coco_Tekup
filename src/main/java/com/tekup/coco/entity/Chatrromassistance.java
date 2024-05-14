package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Chatrromassistance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer chatRoomId;
    private String description;
    private String nom;
    private boolean status;
    @ManyToOne
    private User owner;
    @OneToMany(mappedBy = "chatroom" ,cascade = CascadeType.ALL)
    private List<MessageChattrom> messages;
    @ManyToMany
    private List<User> users;
}
