package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "AnnonceCollocation")
public class AnnonceCollocation extends Annonce{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
