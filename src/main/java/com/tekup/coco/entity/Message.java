package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tekup.coco.entity.enummeration.MessageType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "Message")
public class Message implements Serializable {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  messageId;
    String body;
    LocalDateTime date;
    @JsonIgnore
    @ManyToOne
    User sender;
    @JsonIgnore
    @ManyToOne
    User reciver;
    @JsonIgnore
    @ManyToOne
    Chatroom chatroom;
}
