package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.Dto.Demande_visiteDto;
import com.tekup.coco.entity.AnnonceCollocation;
import com.tekup.coco.entity.Demande_visite;
import com.tekup.coco.entity.User;
import com.tekup.coco.repository.AnnonceCollocationRepository;
import com.tekup.coco.repository.Demande_visiteRepository;
import com.tekup.coco.repository.UserRepo;
import com.tekup.coco.services.Demande_visiteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class Demande_visiteServiceImp implements Demande_visiteService {
    @Autowired
    Demande_visiteRepository demandeVisiteRepository;
    private final UserRepo userRepo;
    private final AnnonceCollocationRepository annonceCollocationRepository;

    @Override
    public Demande_visiteDto createDemandeVisite(Demande_visiteDto demandeVisite) {
        Demande_visite demandeVisite1 = new Demande_visite();
        demandeVisite1.setRendez_vous(demandeVisite.getRendez_vous());
        demandeVisite1.setStatus(demandeVisite.getStatus());
       User user1 = userRepo.findById(demandeVisite.getUserId()).get();
       demandeVisite1.setUser(user1);
        AnnonceCollocation annonceCollocation= annonceCollocationRepository.findById(demandeVisite.getCollocationId()).get();
        demandeVisite1.setAnnonceCollocation(annonceCollocation);
        demandeVisiteRepository.save(demandeVisite1);
        return demandeVisite;
    }

    public Demande_visite getDemandeVisiteById(Long id) {
        return demandeVisiteRepository.findById(id).get();
    }

    @Override
    public Demande_visite updateDemandeVisite(Demande_visiteDto demandeVisite) {
        return null;
    }

    public List<Demande_visite> getAllDemandeVisite(){
        List<Demande_visite> listDemande = demandeVisiteRepository.findAll();
        return listDemande ;
    }

    public void deleteDemandeVisite(Long demandeId){
        demandeVisiteRepository.deleteById(demandeId);
    }
    public Demande_visite updateDemandeVisite(Demande_visite demandeVisite){
        Demande_visite   demandeVisites = demandeVisiteRepository.save(demandeVisite);
        return demandeVisites ;
    }
}