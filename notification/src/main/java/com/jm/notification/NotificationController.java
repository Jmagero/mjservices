package com.jm.notification;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    final  private NotificationService notificationService;
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        notificationService.send(notificationRequest);
    }
}
