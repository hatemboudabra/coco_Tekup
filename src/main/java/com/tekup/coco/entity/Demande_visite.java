package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "demande_visite")
public class Demande_visite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date rendez_vous;
    private String status;
    @ManyToOne
    private Etudiant etudiant;
}
