package com.tekup.coco.services.ServiceImpl;

import com.tekup.coco.Dto.NotificationDto;
import com.tekup.coco.entity.Notification;
import com.tekup.coco.entity.Reservation;
import com.tekup.coco.entity.User;
import com.tekup.coco.repository.NotificationReppository;
import com.tekup.coco.repository.ReservationRepo;
import com.tekup.coco.repository.UserRepo;
import com.tekup.coco.services.NotificationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
    private final NotificationReppository notificationReppository;
    private final ReservationRepo reservationRepository;
    private final UserRepo userRepository;
    private List<Notification> notifications;

    @Autowired
    public NotificationServiceImpl(NotificationReppository notificationReppository, ReservationRepo reservationRepository, UserRepo userRepository) {
        this.notificationReppository = notificationReppository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Notification> getAllNotification() {
        return notificationReppository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationReppository.findById(id);    }

    @Override
    public Notification addNotification(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setMessage(notificationDto.getMessage());
        User user = userRepository.findById(notificationDto.getIdUser()).get();
        Reservation reservation= reservationRepository.findById(notificationDto.getIdReservation()).get();
        notification.setReservation(reservation);
        notification.setUser(user);
        notification = notificationReppository.save(notification);
        user.getNotificationList().add(notification);
        reservation.getNotificationList().add(notification);
        reservationRepository.save(reservation);
        userRepository.save(user);
        return  notification ;
    }

    @Override
    public Notification updateNotification(Long notificationId, NotificationDto updatedNotificationDto) {
        Optional<Notification> optionalNotification = notificationReppository.findById(notificationId);
        if (optionalNotification.isPresent()) {
            Notification notification = optionalNotification.get();
            notification.setMessage(updatedNotificationDto.getMessage());
            User user = userRepository.findById(updatedNotificationDto.getIdUser()).get();
            Reservation reservation = reservationRepository.findById(updatedNotificationDto.getIdReservation()).get();
            notification.getUser().getNotificationList().remove(notification);
            notification.getReservation().getNotificationList().remove(notification);
            // Update associations
            notification.setUser(user);
            notification.setReservation(reservation);
            // Save the updated Notification object
            notification = notificationReppository.save(notification);
            user.getNotificationList().add(notification);
            reservation.getNotificationList().add(notification);
            userRepository.save(user);
            reservationRepository.save(reservation);
            return notification;
        } else {

            return null;
        }
        }

    @Override
    public void deleteNotification(Long id) {
        notificationReppository.deleteById(id);
    }

    @Override
    public List<Notification> trierNotificationParDate() {
        List<Notification> notificationss =notificationReppository.findAll();
        return notificationss.stream().sorted(Comparator.comparing(Notification::getSendDate))
                .collect(Collectors.toList());
    }


    public List<Notification> findNotificationsByUserId(Long userId) {
        return notificationReppository.findNotificationsByUserId(userId);
    }


}
