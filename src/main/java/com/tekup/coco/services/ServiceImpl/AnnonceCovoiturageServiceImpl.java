package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.User;
import com.tekup.coco.repository.AnnonceCovoiturageRepo;
import com.tekup.coco.repository.UserRepo;
import com.tekup.coco.services.AnnonceCovoiturageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class AnnonceCovoiturageServiceImpl implements AnnonceCovoiturageService {
    private final AnnonceCovoiturageRepo annonceCovoiturageRepo;
    private final UserRepo userRepository;

    @Autowired
    public AnnonceCovoiturageServiceImpl(AnnonceCovoiturageRepo annonceCovoiturageRepo, UserRepo userRepository) {
        this.annonceCovoiturageRepo = annonceCovoiturageRepo;
        this.userRepository = userRepository;
    }
    @Override
    public AnnonceCovoiturage addAnnonce(AnnonceCovoiturageDto annonceCovoiturageDto) {
        AnnonceCovoiturage annonceCovoiturage = new AnnonceCovoiturage();
        annonceCovoiturage.setDesignation(annonceCovoiturageDto.getDesignation());
        annonceCovoiturage.setHeure_Depart(annonceCovoiturageDto.getHeure_Depart());
        annonceCovoiturage.setLieu_depart(annonceCovoiturageDto.getLieu_depart());
        annonceCovoiturage.setNbrePlaceDisponible(annonceCovoiturageDto.getNbrePlaceDisponible());
        annonceCovoiturage.setTypeCovoiturage(annonceCovoiturageDto.getTypeCovoiturage());
        User user = userRepository.findById(annonceCovoiturageDto.getIdUSEr()).get();
        annonceCovoiturage.setUser(user);
        annonceCovoiturage = annonceCovoiturageRepo.save(annonceCovoiturage);
        user.getAnnonceCovoiturageList().add(annonceCovoiturage);
        userRepository.save(user);
        return annonceCovoiturage;
    }
    @Override
    public AnnonceCovoiturage updateAnnonce(Long id, AnnonceCovoiturageDto annonceCovoiturageDto) {
        Optional<AnnonceCovoiturage> optionalAnnonceCovoiturage = annonceCovoiturageRepo.findById(id);
        if (optionalAnnonceCovoiturage.isPresent()){
            AnnonceCovoiturage annonceCovoiturage= optionalAnnonceCovoiturage.get();
            annonceCovoiturage.setDesignation(annonceCovoiturageDto.getDesignation());
            annonceCovoiturage.setHeure_Depart(annonceCovoiturageDto.getHeure_Depart());
            annonceCovoiturage.setLieu_depart(annonceCovoiturageDto.getLieu_depart());
            annonceCovoiturage.setNbrePlaceDisponible(annonceCovoiturageDto.getNbrePlaceDisponible());
            annonceCovoiturage.setTypeCovoiturage(annonceCovoiturageDto.getTypeCovoiturage());

            User user = userRepository.findById(annonceCovoiturageDto.getIdUSEr()).orElse(null);
            if (user != null) {
                if (annonceCovoiturage.getUser() != null) {
                    annonceCovoiturage.getUser().getAnnonceCovoiturageList().remove(annonceCovoiturage);
                }
                annonceCovoiturage.setUser(user);
                user.getAnnonceCovoiturageList().add(annonceCovoiturage);
                userRepository.save(user);
            }

            annonceCovoiturage = annonceCovoiturageRepo.save(annonceCovoiturage);

            return annonceCovoiturage;
        } else {
            return null;
        }
    }
    @Override
    public Optional<AnnonceCovoiturage> findById(Long id) {
        return annonceCovoiturageRepo.findById(id);
    }
    @Override
    public List<AnnonceCovoiturage> findAll() {
        return annonceCovoiturageRepo.findAll();
    }
    @Override
    public void delete(Long id) {
        annonceCovoiturageRepo.deleteById(id);
    }

    @Override
    public List<AnnonceCovoiturage> trierAnnonceCovoiturageParDate() {
        List<AnnonceCovoiturage>annonceCovoiturages = annonceCovoiturageRepo.findAll();
        return  annonceCovoiturages.stream().sorted(Comparator.comparing(AnnonceCovoiturage::getHeure_Depart).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Map<User, Integer> annoncesParUser() {
        List<AnnonceCovoiturage> annonces = annonceCovoiturageRepo.findAll();
        Map<User, Integer> annoncesParUser = new HashMap<>();

        for (AnnonceCovoiturage annonce : annonces) {
            User user = annonce.getUser();
            annoncesParUser.put(user, annoncesParUser.getOrDefault(user, 0) + 1);
        }

            return annoncesParUser;
    }

    public  List<AnnonceCovoiturage> findByLieuDepart(String lieuDepart){
        return annonceCovoiturageRepo.findByLieuDepart(lieuDepart);
    }
     public List<AnnonceCovoiturage> rechercherAnnoncesParUtilisateur(Long userId){
        return annonceCovoiturageRepo.findAnnonceCovoiturageByUserId(userId);
    }
}
