package com.tekup.coco.services;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;

import java.util.List;

public interface AnnonceCovoiturageService {
    AnnonceCovoiturageDto save (AnnonceCovoiturageDto annonceCovoiturageDto);
    AnnonceCovoiturageDto findById(Long id);
    List<AnnonceCovoiturageDto> findAll();
    void delete(Long id);

}
