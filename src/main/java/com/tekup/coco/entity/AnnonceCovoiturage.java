package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "AnnonceCovoiturage")
public class AnnonceCovoiturage extends Annonce{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
