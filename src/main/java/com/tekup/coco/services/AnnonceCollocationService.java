package com.tekup.coco.services;

import com.tekup.coco.Dto.AnnonceCollocationDto;
import com.tekup.coco.entity.AnnonceCollocation;

import java.util.List;
import java.util.Optional;

public interface AnnonceCollocationService {
   public AnnonceCollocation addAnnonce(AnnonceCollocationDto annonceCollocationDto);
   AnnonceCollocation updateAnnonce(Long id,AnnonceCollocationDto annonceCollocationDto);
   List<AnnonceCollocation> getAllAnnonces();
   void deleteAnnonceById(Long id);
}
