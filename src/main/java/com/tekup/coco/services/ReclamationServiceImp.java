package com.tekup.coco.services;

import com.tekup.coco.entity.Reclamation;
import com.tekup.coco.repository.ReclamationRepo;
import org.springframework.stereotype.Service;


@Service
public class ReclamationServiceImp implements ReclamationService {
    ReclamationRepo reclamationRepo;

    public Reclamation createReclamation(Reclamation reclamation){
        return reclamationRepo.save(reclamation);
    }



    public void deleteReclamation (Long reclamtionId){
        reclamationRepo.deleteById(reclamtionId);
    }
    public Reclamation getReclamationByUserID(Long userId) {
    return reclamationRepo.findById(userId).get();
    }
}
