package com.tekup.coco.Dto;

import com.tekup.coco.entity.Etudiant;
import com.tekup.coco.entity.Reclamation;
import com.tekup.coco.entity.enummeration.Status;
import com.tekup.coco.entity.enummeration.TypeClaim;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
public class ReclamationDto {
    private String title;
    private String otherDetails;
    private String description;
    private TypeClaim typeClaim;
    private Status statusClaims;
    private LocalDateTime CreatedAt;
    private LocalDateTime   ConsultAt;
    private Long iduser;

}
