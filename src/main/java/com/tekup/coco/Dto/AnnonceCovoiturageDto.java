package com.tekup.coco.Dto;

import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.User;
import com.tekup.coco.entity.enummeration.Type_Covoiturage;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class AnnonceCovoiturageDto {
    private String designation;
    private Date heure_Depart;
    private String Lieu_depart;
    private Long nbrePlaceDisponible;
    private Type_Covoiturage typeCovoiturage;
    private UserDto userId;
   // private Long reservationId;
    public static AnnonceCovoiturageDto fromEntity(AnnonceCovoiturage annonceCovoiturage) {
        if (annonceCovoiturage == null) {
            return null;

        }

        return AnnonceCovoiturageDto.builder()
                .designation(annonceCovoiturage.getDesignation())
                .heure_Depart(annonceCovoiturage.getHeure_Depart())
                .Lieu_depart(annonceCovoiturage.getLieu_depart())
                .nbrePlaceDisponible(annonceCovoiturage.getNbrePlaceDisponible())
                .typeCovoiturage(annonceCovoiturage.getTypeCovoiturage())
                .userId(UserDto.fromEntity(annonceCovoiturage.getUser()))
                .build();
    }

    public static AnnonceCovoiturage toEntity(AnnonceCovoiturageDto annonceCovoiturageDto) {
        if (annonceCovoiturageDto == null) {
            return null;

        }

        AnnonceCovoiturage annonceCovoiturage = new AnnonceCovoiturage();
        annonceCovoiturage.setDesignation(annonceCovoiturageDto.getDesignation());
        annonceCovoiturage.setHeure_Depart(annonceCovoiturageDto.getHeure_Depart());
        annonceCovoiturage.setLieu_depart(annonceCovoiturageDto.getLieu_depart());
        annonceCovoiturage.setNbrePlaceDisponible(annonceCovoiturageDto.getNbrePlaceDisponible());
        annonceCovoiturage.setTypeCovoiturage(annonceCovoiturageDto.getTypeCovoiturage());
        annonceCovoiturage.setUser(UserDto.toEntity(annonceCovoiturageDto.getUserId()));


        return annonceCovoiturage;
    }

}
