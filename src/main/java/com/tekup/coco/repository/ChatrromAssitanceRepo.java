package com.tekup.coco.repository;

import com.tekup.coco.entity.Chatrromassistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatrromAssitanceRepo extends JpaRepository<Chatrromassistance,Integer> {
}
