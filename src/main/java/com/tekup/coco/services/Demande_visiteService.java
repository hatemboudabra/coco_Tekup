package com.tekup.coco.services;

import com.tekup.coco.entity.Demande_visite;

import java.util.List;

public interface Demande_visiteService {
    public Demande_visite createDemandeVisite(Demande_visite demandeVisite);
    public  Demande_visite getDemandeVisiteById(Long id);
    public Demande_visite updateDemandeVisite(Demande_visite demandeVisite);
    public List<Demande_visite> getAllDemandeVisite();
    public void deleteDemandeVisite (Long id);

}
