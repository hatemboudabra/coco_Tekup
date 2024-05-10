package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ReponseMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idreponse;
    private String content;
    @ManyToOne
    private User user;
    @OneToOne
    @JsonIgnore
    private MessageChattrom message;
}
