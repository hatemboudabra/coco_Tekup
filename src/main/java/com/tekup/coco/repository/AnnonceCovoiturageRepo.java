package com.tekup.coco.repository;

import com.tekup.coco.entity.AnnonceCovoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceCovoiturageRepo extends JpaRepository<AnnonceCovoiturage,Long> {
}
