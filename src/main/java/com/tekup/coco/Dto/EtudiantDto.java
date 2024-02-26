package com.tekup.coco.Dto;

import com.tekup.coco.entity.Demande_visite;
import com.tekup.coco.entity.Etudiant;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EtudiantDto {
    private String specialite;
    private String classe;
    private String adress_email;

    public static EtudiantDto fromEntity(Etudiant etudiant) {
        if (etudiant == null) {
            return null;
        }
        return
                EtudiantDto.builder()
                        .specialite(etudiant.getSpecialite())
                        .classe(etudiant.getClasse())
                        .adress_email(etudiant.getAdress_email())
                        .build();
    }

    public static Etudiant toEntity(EtudiantDto etudiantDto) {
        if (etudiantDto == null) {
            return null;
        }

        Etudiant etudiant = new Etudiant();
        etudiant.setSpecialite(etudiantDto.getSpecialite());
        etudiant.setClasse(etudiantDto.getClasse());
        etudiant.setAdress_email(etudiantDto.getAdress_email());


        return etudiant;


    }
}