package com.tekup.coco.services;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.entity.AnnonceCovoiturage;

import java.util.List;
import java.util.Optional;

public interface AnnonceCovoiturageService {
    AnnonceCovoiturageDto save (AnnonceCovoiturageDto annonceCovoiturageDto);
    AnnonceCovoiturageDto findById(Integer id);
    AnnonceCovoiturageDto findAll();
    void delete(Integer id);

}
