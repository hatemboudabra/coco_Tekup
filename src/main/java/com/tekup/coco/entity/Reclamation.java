package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tekup.coco.entity.enummeration.Status;
import com.tekup.coco.entity.enummeration.TypeClaim;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClaims")
    private Integer idClaims;
    private String title;
    private String otherDetails;
    private String description;
    @Enumerated(EnumType.STRING)
    private TypeClaim typeClaim;
    @Enumerated(EnumType.STRING)
    private Status statusClaims;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime CreatedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime   ConsultAt;
    @ManyToOne
    private User user;
}
