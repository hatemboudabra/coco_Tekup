package com.tekup.coco.repository;

import com.tekup.coco.entity.AnnonceCollocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AnnonceCollocationRepository extends JpaRepository<AnnonceCollocation, Long> {
}
