package com.tekup.coco.services;
import com.tekup.coco.entity.Avis;
import com.tekup.coco.repository.AvisRepo;
import org.springframework.stereotype.Service;

@Service
public class AvisServiceImp implements AvisService{
   AvisRepo avisRepo ;

    public Avis createAvis(Avis avis){
        return avisRepo.save(avis);
    }


    public void deleteAvis (Long avisId){
        avisRepo.deleteById(avisId);
    }
    public Avis getAvisByUserID(Long userId) {
        return avisRepo.findById(userId).get();
    }
}


