package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.entity.AnnonceCollocation;
import com.tekup.coco.repository.AnnonceCollocationRepository;
import com.tekup.coco.services.AnnonceCollocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class AnnonceCollocationServiceImpl implements AnnonceCollocationService {
    @Autowired
    private AnnonceCollocationRepository annonceCollocationRepository;

    @Override
    public List<AnnonceCollocation> getAllAnnonces() {
        return annonceCollocationRepository.findAll();
    }

    @Override
    public Optional<AnnonceCollocation> getAnnonceById(Long id) {
        return annonceCollocationRepository.findById(id);
    }

    @Override
    public AnnonceCollocation saveOrUpdateAnnonce(AnnonceCollocation annonce) {
        return annonceCollocationRepository.save(annonce);
    }

    @Override
    public void deleteAnnonceById(Long id) {
        annonceCollocationRepository.deleteById(id);
    }
}
