package com.tekup.coco.repository;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.Dto.UserDto;
import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.Notification;
import com.tekup.coco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnnonceCovoiturageRepo extends JpaRepository<AnnonceCovoiturage,Long> {

/*
    @Query("SELECT a FROM AnnonceCovoiturage a WHERE a.Lieu_depart = :lieuDepart")
    List<AnnonceCovoiturage> findByLieuDepart(@Param("lieuDepart") String lieuDepart);
*/

}
