package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Annonce")
public class Annonce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    User user;
    @OneToMany
    List<Avis> avisList = new ArrayList<>();
    @OneToMany
    List<Reservation> reservationList = new ArrayList<>();
}
