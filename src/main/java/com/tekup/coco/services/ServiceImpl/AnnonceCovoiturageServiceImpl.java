package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.repository.AnnonceCovoiturageRepo;
import com.tekup.coco.services.AnnonceCovoiturageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceCovoiturageServiceImpl implements AnnonceCovoiturageService {
    private final AnnonceCovoiturageRepo annonceCovoiturageRepo;

    public AnnonceCovoiturageServiceImpl(AnnonceCovoiturageRepo annonceCovoiturageRepo) {
        this.annonceCovoiturageRepo = annonceCovoiturageRepo;
    }

    @Override
    public AnnonceCovoiturageDto save(AnnonceCovoiturageDto annonceCovoiturageDto) {
        return AnnonceCovoiturageDto.fromEntity(annonceCovoiturageRepo
                .save(AnnonceCovoiturageDto.toEntity(annonceCovoiturageDto))) ;
    }

    @Override
    public AnnonceCovoiturageDto findById(Long id) {
        return null;
    }

    @Override
    public List<AnnonceCovoiturageDto> findAll() {
        return annonceCovoiturageRepo.findAll().stream()
                .map(AnnonceCovoiturageDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Long id) {

    }


}
