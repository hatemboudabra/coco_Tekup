package com.tekup.coco.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @OneToOne
    User user;
    @OneToMany
    List<AnnonceCovoiturage> annonceCovoiturageList;
    @OneToMany
    List<Notification> notificationList=new ArrayList<>();
}
