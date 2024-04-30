package com.tekup.coco.repository;

import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.Reservation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE AnnonceCovoiturage a SET a.nbrePlaceDisponible = a.nbrePlaceDisponible - :placesReservees WHERE a.id = :annonceId AND a.nbrePlaceDisponible >= :placesReservees AND a.nbrePlaceDisponible > 0")
    void reserverPlace(@Param("annonceId") Long annonceId, @Param("placesReservees") Long placesReservees);



}
