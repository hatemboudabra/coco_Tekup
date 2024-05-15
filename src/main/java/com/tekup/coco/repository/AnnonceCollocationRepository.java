package com.tekup.coco.repository;

import com.tekup.coco.entity.AnnonceCollocation;
import com.tekup.coco.entity.AnnonceCovoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AnnonceCollocationRepository extends JpaRepository<AnnonceCollocation, Long> {
    @Query("SELECT n FROM AnnonceCollocation n JOIN n.user u WHERE u.id = :userId")
    List<AnnonceCollocation> findAnnonceCollocationByUserId(@Param("userId") Long userId);
}
