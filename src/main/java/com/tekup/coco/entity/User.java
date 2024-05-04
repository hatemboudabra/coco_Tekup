package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String username;
    private String email;
    private String password;
    @OneToOne
    private Message message;
    @OneToMany
     List<Reclamation> reclamationList ;
    @OneToMany
    private List<AnnonceCovoiturage> annonceCovoiturageList ;
    @OneToMany
    private  List<AnnonceCollocation> annonceCollocationList;
    @OneToOne
    private  Reservation reservation;


}
