package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.Dto.UserDto;
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
        annonceCovoiturage.setLieu_fin(annonceCovoiturageDto.getLieu_fin());
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
            annonceCovoiturage.setLieu_fin(annonceCovoiturageDto.getLieu_fin());
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

    public  List<AnnonceCovoiturage> findByLieuDepart(String lieuDepart){
        return annonceCovoiturageRepo.findByLieuDepart(lieuDepart);
    }
     public List<AnnonceCovoiturage> rechercherAnnoncesParUtilisateur(Long userId){
        return annonceCovoiturageRepo.findAnnonceCovoiturageByUserId(userId);
    }
    @Override
    public Map<UserDto, Integer> annoncesParUserService() {
        List<AnnonceCovoiturage> annonces = annonceCovoiturageRepo.findAll();
        Map<UserDto, Integer> annoncesParUser = new HashMap<>();

        for (AnnonceCovoiturage annonce : annonces) {
            User user = annonce.getUser();
            UserDto userDto = new UserDto();
            userDto.setUsername(user.getUsername());
            userDto.setEmail(user.getEmail());

            annoncesParUser.put(userDto, annoncesParUser.getOrDefault(userDto, 0) + 1);
        }

        return annoncesParUser;
    }@Override
    public UserDto getUserAvecLePlusDAnnonces() {
        Map<UserDto, Integer> annoncesParUser = annoncesParUserService();
        UserDto userAvecLePlusDAnnonces = null;
        int maxAnnonces = 0;

        for (Map.Entry<UserDto, Integer> entry : annoncesParUser.entrySet()) {
            UserDto userDto = entry.getKey();
            Integer nombreAnnonces = entry.getValue();

            if (nombreAnnonces > maxAnnonces) {
                maxAnnonces = nombreAnnonces;
                userAvecLePlusDAnnonces = userDto;
            }
        }

        if (userAvecLePlusDAnnonces != null) {
            String username = userAvecLePlusDAnnonces.getUsername();
            userAvecLePlusDAnnonces.setAnnouncementCount(maxAnnonces);
            int nombreAnnonces = userAvecLePlusDAnnonces.getAnnouncementCount();

            // Return the username and number of announcements
            System.out.println("Username: " + username);
            System.out.println("Number of Announcements: " + nombreAnnonces);
        }

        return userAvecLePlusDAnnonces;
    }

}