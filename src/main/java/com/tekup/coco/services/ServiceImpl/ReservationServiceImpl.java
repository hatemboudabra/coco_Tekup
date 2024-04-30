package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.Reservation;
import com.tekup.coco.repository.AnnonceCovoiturageRepo;
import com.tekup.coco.repository.ReservationRepo;
import com.tekup.coco.services.ReservationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepo reservationRepo;
    private final AnnonceCovoiturageRepo annonceCovoiturageRepo;
    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo, AnnonceCovoiturageRepo annonceCovoiturageRepo) {
        this.reservationRepo = reservationRepo;
        this.annonceCovoiturageRepo = annonceCovoiturageRepo;
    }
    @Transactional
    public void reserverAnnonce(Long annonceId, Long placesReservees) {
        reservationRepo.reserverPlace(annonceId, placesReservees);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepo.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepo.deleteById(id);
    }

}
