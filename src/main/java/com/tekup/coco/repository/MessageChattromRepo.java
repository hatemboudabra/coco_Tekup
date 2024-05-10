package com.tekup.coco.repository;

import com.tekup.coco.entity.MessageChattrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageChattromRepo extends JpaRepository<MessageChattrom,Integer> {
}