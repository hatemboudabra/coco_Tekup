package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") ,
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;
   // @OneToOne
    //private Message message;
   @OneToMany(mappedBy = "user")
   private Set<Reclamation> claims;
    @OneToMany
    private List<AnnonceCovoiturage> annonceCovoiturageList = new ArrayList<>();
    @OneToMany
    List<Demande_visite> demandeVisites = new ArrayList<>();
    @OneToMany
    private  List<AnnonceCollocation> annonceCollocationList;
    @OneToOne
    private  Reservation reservation;
    @OneToMany
    List<Notification> notificationList=new ArrayList<>();
    public User(Long id,String username,String password,boolean enabled,List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Chatrromassistance> joinedchatrooms;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonIgnore
    private   List<Chatrromassistance>myrooms;
}
