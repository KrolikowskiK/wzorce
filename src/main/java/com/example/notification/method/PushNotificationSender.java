package com.example.notification.method;

import com.example.notification.NotificationSender;

public class PushNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String message) {
        System.out.println("Wysyłanie powiadomienia push: " + message);
    }
}
