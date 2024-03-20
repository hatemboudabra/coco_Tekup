package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tekup.coco.entity.enummeration.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Reclamation")
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text_recl;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime CreatedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime   ConsultAt;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status type_reclamation;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    AnnonceCovoiturage annonceCovoiturage;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    AnnonceCollocation annonceCollocation;
}
