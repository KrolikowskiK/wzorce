package com.example.notification.method;

import com.example.notification.NotificationSender;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String message) {
        System.out.println("Wysyłanie powiadomienia e-mail: " + message);
    }
}