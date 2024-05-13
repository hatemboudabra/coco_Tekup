package com.tekup.coco.repository;

import com.tekup.coco.entity.Demande_visite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Demande_visiteRepository extends JpaRepository<Demande_visite,Long> {
}