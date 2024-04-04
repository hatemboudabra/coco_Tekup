package com.tekup.coco.services;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.entity.AnnonceCovoiturage;

import java.util.List;
import java.util.Optional;

public interface AnnonceCovoiturageService {
    AnnonceCovoiturage addAnnonce (AnnonceCovoiturageDto annonceCovoiturageDto);
    AnnonceCovoiturage updateAnnonce (Long id , AnnonceCovoiturageDto annonceCovoiturageDto);
    public Optional<AnnonceCovoiturage> findById(Long id);
    List<AnnonceCovoiturage> findAll();
    void delete(Long id);

}
