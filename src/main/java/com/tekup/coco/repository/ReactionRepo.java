package com.tekup.coco.repository;

import com.tekup.coco.entity.ReactionMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepo extends JpaRepository<ReactionMessage, Integer> {
}
