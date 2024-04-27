package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.entity.Reservation;
import com.tekup.coco.repository.AnnonceCovoiturageRepo;
import com.tekup.coco.repository.NotificationReppository;
import com.tekup.coco.repository.ReservationRepo;
import com.tekup.coco.repository.UserRepo;
import com.tekup.coco.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepo reservationRepo;
    private final NotificationReppository notificationReppository;
    private final AnnonceCovoiturageRepo annonceCovoiturageRepo;
    private final UserRepo userRepo;

    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo, NotificationReppository notificationReppository, AnnonceCovoiturageRepo annonceCovoiturageRepo, UserRepo userRepo) {
        this.reservationRepo = reservationRepo;
        this.notificationReppository = notificationReppository;
        this.annonceCovoiturageRepo = annonceCovoiturageRepo;
        this.userRepo = userRepo;
    }


    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
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
