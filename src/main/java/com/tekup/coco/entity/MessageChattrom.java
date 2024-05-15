package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class MessageChattrom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    private String content;
    private Date dateTime;
    @ManyToOne
    @JsonIgnore
    private  Chatrromassistance chatroom;
    @ManyToOne
    @JsonIgnore
    private User user;
    @OneToOne(mappedBy = "message" ,cascade = CascadeType.ALL)

    private ReponseMessage reponse;
    @OneToMany(mappedBy = "msg" ,cascade = CascadeType.ALL)

    private List<ReactionMessage> reactions;
}
