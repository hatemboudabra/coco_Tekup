package com.tekup.coco.services;

import com.tekup.coco.entity.Reclamation;


public interface ReclamationService {
    public Reclamation createReclamation(Reclamation reclamation);
    public Reclamation getReclamationByUserID(Long userID);

    public void deleteReclamation(Long id);


}
