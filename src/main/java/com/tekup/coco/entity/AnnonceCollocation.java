package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tekup.coco.entity.enummeration.Type_Anno_Collo;
import com.tekup.coco.entity.enummeration.Type_Logement;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "AnnonceCollocation")
public class AnnonceCollocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_dispo;
    private Long nbre_chmbre;
    private String descrption;
    private Long Montant;
    private Long nbre_person;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Type_Logement typeLogement;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Type_Anno_Collo  typeAnnoColloc;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    User user;
    @OneToMany
    List<Avis> avisList;
    @OneToOne
    Demande_visite demandeVisite;
}
