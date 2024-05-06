package com.tekup.coco.repository;

import com.tekup.coco.entity.Reclamation;
import com.tekup.coco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepo extends JpaRepository<Reclamation,Integer> {
    public Reclamation findByIdClaims (Integer idClaims);
    List<Reclamation> findByUser(User u);
}
