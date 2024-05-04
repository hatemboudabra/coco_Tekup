package com.tekup.coco.entity;

import com.tekup.coco.Controller.DemandeVisiteControllerRes;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity

public class Demande_visite  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date rendez_vous;
    private String status;
    @ManyToOne
    private Etudiant etudiant;
    @OneToOne
    AnnonceCollocation annonceCollocation;


}
