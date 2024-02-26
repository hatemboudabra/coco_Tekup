package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Etudiant")
public class Etudiant extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialite;
    private String classe;
    private String adress_domicil;
    @OneToMany
    List<Demande_visite> demandeVisites = new ArrayList<>();

}
