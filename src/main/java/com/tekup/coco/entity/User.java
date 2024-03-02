package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name ="User" )
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @OneToOne
    private Message message;
    @OneToMany
     List<Reclamation> reclamationList ;
    @OneToMany
    private List<AnnonceCovoiturage> annonceCovoiturageList ;


}
