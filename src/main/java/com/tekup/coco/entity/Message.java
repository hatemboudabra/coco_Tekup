package com.tekup.coco.entity;

import com.tekup.coco.entity.enummeration.MessageType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_receiver;
    private String message;
    private MessageType type;
    private Date datesend;
    @OneToOne
    private User id_sender;
}
