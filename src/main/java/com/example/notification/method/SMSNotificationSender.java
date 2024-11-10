package com.example.notification.method;

import com.example.notification.NotificationSender;

public class SMSNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String message) {
        System.out.println("Wysyłanie powiadomienia SMS: " + message);
    }
}
