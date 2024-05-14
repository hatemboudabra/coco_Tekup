package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Chatroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String name;
    String codeRoom;
    LocalDateTime CreatedAt;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "chatroom")
    List<Message> messages;
    @OneToMany
    List<User> recievres;
}
