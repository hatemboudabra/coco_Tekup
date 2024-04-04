package com.tekup.coco.Dto;

import com.tekup.coco.entity.Etudiant;
import com.tekup.coco.entity.Reclamation;
import com.tekup.coco.entity.enummeration.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReclamationDto {
    private String text_recl;
    private LocalDateTime CreatedAt;
    private LocalDateTime  ConsultAt;
    private Status type_reclamation;
    private UserDto user;
/*
    public static ReclamationDto fromEntity(Reclamation reclamation) {
        if (reclamation == null) {
            return null;
        }
        return
                ReclamationDto.builder()
                        .text_recl(reclamation.getText_recl())
                        .CreatedAt(reclamation.getCreatedAt())
                        .ConsultAt(reclamation.getConsultAt())
                        .type_reclamation(reclamation.getType_reclamation())
                        .user(UserDto.fromEntity(reclamation.getUser()))
                        .build();
    }

    public static Reclamation toEntity(ReclamationDto reclamationDto) {
        if (reclamationDto == null) {
            return null;
        }

        Reclamation reclamation = new Reclamation();
        reclamation.setText_recl(reclamationDto.getText_recl());
        reclamation.setCreatedAt(reclamationDto.getCreatedAt());
        reclamation.setConsultAt(reclamationDto.getConsultAt());
        reclamation.setType_reclamation(reclamationDto.getType_reclamation());
        reclamation.setUser(UserDto.toEntity(reclamationDto.getUser()));

        return reclamation;


    }

 */
}
