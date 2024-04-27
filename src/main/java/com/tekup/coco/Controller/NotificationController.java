package com.tekup.coco.Controller;

import com.tekup.coco.Dto.NotificationDto;
import com.tekup.coco.entity.Notification;
import com.tekup.coco.services.ServiceImpl.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/Notification")
public class NotificationController {
    private final NotificationServiceImpl notificationService;
    @Autowired
    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }



    @PostMapping(path = "/addNotification")
    public Notification addNotification(@RequestBody NotificationDto notificationDto){
        return  notificationService.addNotification(notificationDto);
    }
    @GetMapping
    public List<Notification> getAllNotification(){
        return notificationService.getAllNotification();

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable("id") long id){
        notificationService.deleteNotification(id);
        return new ResponseEntity<String>("notification deleted successfully!.", HttpStatus.OK);
    }

    @GetMapping("/sortbyDate")
    public List<Notification>trierNotificationParDate(){
     return    notificationService.trierNotificationParDate();
    }


}
