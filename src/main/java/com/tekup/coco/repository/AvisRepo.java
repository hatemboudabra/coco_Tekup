package com.tekup.coco.repository;

import com.tekup.coco.entity.Avis;
import com.tekup.coco.entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepo  extends JpaRepository<Avis,Long> {
}
