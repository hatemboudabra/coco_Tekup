package com.tekup.coco.repository;

import com.tekup.coco.entity.ReponseMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseRepo extends JpaRepository<ReponseMessage, Integer> {
}
