package com.tekup.coco.services;

import com.tekup.coco.entity.Avis;

public interface AvisService {
    public Avis createAvis(Avis avis);
    public Avis getAvisByUserID(Long userID);

    public void deleteAvis(Long id);

}
