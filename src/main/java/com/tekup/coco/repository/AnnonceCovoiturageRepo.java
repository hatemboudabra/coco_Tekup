package com.tekup.coco.repository;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.Notification;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceCovoiturageRepo extends JpaRepository<AnnonceCovoiturage,Long> {
    @Query("SELECT a FROM AnnonceCovoiturage a WHERE a.Lieu_depart = :lieuDepart")
    List<AnnonceCovoiturage> findByLieuDepart(@Param("lieuDepart") String lieuDepart);
    @Query("SELECT n FROM AnnonceCovoiturage n JOIN n.user u WHERE u.id = :userId")
    List<AnnonceCovoiturage> findAnnonceCovoiturageByUserId(@Param("userId") Long userId);
    @Transactional
    @Modifying
    @Query("DELETE FROM AnnonceCovoiturage a WHERE a.id = :annonceId")
    void deleteByIdWithCustomQuery(Long annonceId);
}
