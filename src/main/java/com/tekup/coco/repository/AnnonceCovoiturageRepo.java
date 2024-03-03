package com.tekup.coco.repository;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.entity.AnnonceCovoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceCovoiturageRepo extends JpaRepository<AnnonceCovoiturage,Long> {

/*
    @Query("SELECT a FROM AnnonceCovoiturage a WHERE a.Lieu_depart = :lieuDepart")
    List<AnnonceCovoiturage> findByLieuDepart(@Param("lieuDepart") String lieuDepart);
*/
}
