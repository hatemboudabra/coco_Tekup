package com.tekup.coco.services;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.Dto.UserDto;
import com.tekup.coco.entity.AnnonceCovoiturage;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AnnonceCovoiturageService {
    public AnnonceCovoiturageDto addAnnonce (AnnonceCovoiturageDto annonceCovoiturageDto);
    AnnonceCovoiturage updateAnnonce (Long id , AnnonceCovoiturageDto annonceCovoiturageDto);
    public Optional<AnnonceCovoiturage> findById(Long id);
    List<AnnonceCovoiturage> findAll();
    //void delete(Long id);
    List <AnnonceCovoiturage> trierAnnonceCovoiturageParDate();
    public Map<Long, Map<String, Object>> annoncesParUserService();
    //   UserDto getUserAvecLePlusDAnnonces();

}
