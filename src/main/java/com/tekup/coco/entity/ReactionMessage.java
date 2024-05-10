package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tekup.coco.entity.enummeration.ReactionType;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class ReactionMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reactionid;
    @Enumerated(EnumType.STRING)
    private ReactionType type;
    @ManyToOne
    private User user;
    @ManyToOne
    @JsonIgnore
    private MessageChattrom msg;
}
