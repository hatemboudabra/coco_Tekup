package com.tekup.coco.services;

import com.tekup.coco.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
    void deleteReservationById(Long id);
}
