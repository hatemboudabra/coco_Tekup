package com.tekup.coco.entity;

import com.tekup.coco.entity.enummeration.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
@Table(name = "Reclamation")
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text_recl;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status type_reclamation;
    @ManyToOne
     User user;
}
