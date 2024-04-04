package com.tekup.coco.services;

import com.tekup.coco.entity.AnnonceCollocation;

import java.util.List;
import java.util.Optional;

public interface AnnonceCollocationService {
    List<AnnonceCollocation> getAllAnnonces();

    Optional<AnnonceCollocation> getAnnonceById(Long id);

    AnnonceCollocation saveOrUpdateAnnonce(AnnonceCollocation annonce);

    void deleteAnnonceById(Long id);
}
