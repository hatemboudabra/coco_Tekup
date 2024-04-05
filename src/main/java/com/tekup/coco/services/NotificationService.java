package com.tekup.coco.services;

import com.tekup.coco.Dto.NotificationDto;
import com.tekup.coco.entity.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    public List<Notification> getAllNotification();
    public Optional<Notification> getNotificationById(Long id);
    public Notification addNotification(NotificationDto notificationDto );

    public Notification updateNotification(Long notificationId, NotificationDto updatedNotificationDto);
    public void deleteNotification(Long id);
}
