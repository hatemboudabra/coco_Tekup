package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.Dto.AnnonceCovoiturageDto;
import com.tekup.coco.entity.AnnonceCovoiturage;
import com.tekup.coco.entity.Reservation;
import com.tekup.coco.repository.AnnonceCovoiturageRepo;
import com.tekup.coco.repository.ReservationRepo;
import com.tekup.coco.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Reservation saveReservation(Reservation reservation) {
        AnnonceCovoiturage annonceCovoiturage = (AnnonceCovoiturage) reservation.getAnnonceCovoiturageList();
        if (annonceCovoiturage.getNbrePlaceDisponible() > 0) {
            annonceCovoiturage.setNbrePlaceDisponible(annonceCovoiturage.getNbrePlaceDisponible() - 1);
            return reservationRepo.save(reservation);
        } else {
            throw new IllegalArgumentException("Aucune place disponible pour cette annonce de covoiturage.");
        }
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
