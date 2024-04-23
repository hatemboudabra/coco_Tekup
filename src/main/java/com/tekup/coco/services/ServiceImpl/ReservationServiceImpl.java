package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.entity.Reservation;
import com.tekup.coco.repository.ReservationRepo;
import com.tekup.coco.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepo reservationRepo;

    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
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
