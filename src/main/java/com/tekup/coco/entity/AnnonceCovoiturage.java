package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tekup.coco.entity.enummeration.Type_Covoiturage;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "AnnonceCovoiturage")
public class AnnonceCovoiturage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private Date heure_Depart;
    private String Lieu_depart;
    private Long nbrePlaceDisponible;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Type_Covoiturage typeCovoiturage;
    @ManyToOne()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    User user;
    @ManyToOne()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Reservation reservation;
    @OneToMany()
    List<Reclamation> reclamationList;

}
