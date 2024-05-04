package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Etudiant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialite;
    private String classe;
    private String adress_domicil;
    @OneToMany
    List<Demande_visite> demandeVisites = new ArrayList<>();

}
