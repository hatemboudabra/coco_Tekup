package com.tekup.coco.Dto;

import com.tekup.coco.entity.ImageModel;
import com.tekup.coco.entity.enummeration.Type_Anno_Collo;
import com.tekup.coco.entity.enummeration.Type_Logement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AnnonceCollocationDto {
    private Long id;
    private Date date_dispo;
    private Long nbre_chmbre;
    private String descrption;
    private Long Montant;
    private Long nbre_person;
    private Type_Logement typeLogement;
    private Type_Anno_Collo typeAnnoColloc;
    private Set<ImageModel> imageModels;
    private Long userId;
}
