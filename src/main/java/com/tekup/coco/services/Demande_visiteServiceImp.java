package com.tekup.coco.services;

import com.tekup.coco.entity.Demande_visite;
import com.tekup.coco.repository.Demande_visiteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class Demande_visiteServiceImp implements Demande_visiteService {

    Demande_visiteRepository demandeVisiteRepository;


    public Demande_visite createDemandeVisite(Demande_visite demandeVisite) {
        return demandeVisiteRepository.save(demandeVisite);
    }


    public Demande_visite getDemandeVisiteById(Long id) {
        return demandeVisiteRepository.findById(id).get();
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



