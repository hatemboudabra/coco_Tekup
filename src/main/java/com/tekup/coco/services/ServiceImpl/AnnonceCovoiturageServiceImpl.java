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
import org.webjars.NotFoundException;

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
    public AnnonceCovoiturageDto addAnnonce(AnnonceCovoiturageDto annonceCovoiturageDto) {
        User user = userRepository.findById(annonceCovoiturageDto.getIdUSEr()).orElse(null);

        if (user != null) {
            if (user.getAnnonceCovoiturageList() != null && !user.getAnnonceCovoiturageList().isEmpty()) {
                AnnonceCovoiturage existingAnnonce = user.getAnnonceCovoiturageList().get(0); // Supposons que l'utilisateur ait une seule annonce, sinon ajustez cette logique
                user.getAnnonceCovoiturageList().remove(existingAnnonce);
                annonceCovoiturageRepo.delete(existingAnnonce);
            }

            AnnonceCovoiturage nouvelleAnnonce = new AnnonceCovoiturage();
            nouvelleAnnonce.setDesignation(annonceCovoiturageDto.getDesignation());
            nouvelleAnnonce.setHeure_Depart(annonceCovoiturageDto.getHeure_Depart());
            nouvelleAnnonce.setLieu_depart(annonceCovoiturageDto.getLieu_depart());
            nouvelleAnnonce.setLieu_fin(annonceCovoiturageDto.getLieu_fin());
            nouvelleAnnonce.setNbrePlaceDisponible(annonceCovoiturageDto.getNbrePlaceDisponible());
            nouvelleAnnonce.setTypeCovoiturage(annonceCovoiturageDto.getTypeCovoiturage());
            nouvelleAnnonce.setUser(user);

            nouvelleAnnonce = annonceCovoiturageRepo.save(nouvelleAnnonce);
            user.getAnnonceCovoiturageList().add(nouvelleAnnonce);
            userRepository.save(user);
        }

        return annonceCovoiturageDto;
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

    public void deleteAnnonceById(Long annonceId) {
        annonceCovoiturageRepo.deleteById(annonceId);
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
public Map<Long, Map<String, Object>> annoncesParUserService() {
    List<AnnonceCovoiturage> annonces = annonceCovoiturageRepo.findAll();
    Map<Long, Map<String, Object>> annoncesParUser = new HashMap<>();

    for (AnnonceCovoiturage annonce : annonces) {
        User user = annonce.getUser();
        Long userId = user.getId();
        String username = user.getUsername();

        Map<String, Object> userStats = annoncesParUser.getOrDefault(userId, new HashMap<>());
        int announcementCount = (int) userStats.getOrDefault("announcementCount", 0);
        userStats.put("announcementCount", announcementCount + 1);
        userStats.put("username", username);
        annoncesParUser.put(userId, userStats);
    }

    // Sort the map entries by announcement count in descending order
    List<Map.Entry<Long, Map<String, Object>>> sortedEntries = new ArrayList<>(annoncesParUser.entrySet());
    sortedEntries.sort((entry1, entry2) -> {
        int count1 = (int) entry1.getValue().getOrDefault("announcementCount", 0);
        int count2 = (int) entry2.getValue().getOrDefault("announcementCount", 0);
        return Integer.compare(count2, count1);
    });

    // Create a new map to store the top 5 user IDs, usernames, and their announcement counts
    Map<Long, Map<String, Object>> topUsers = new LinkedHashMap<>();
    int count = 0;
    for (Map.Entry<Long, Map<String, Object>> entry : sortedEntries) {
        if (count >= 5) {
            break;
        }
        topUsers.put(entry.getKey(), entry.getValue());
        count++;
    }

    return topUsers;
}
}