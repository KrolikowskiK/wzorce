package com.example.notification;

public class EmailNotificationSender extends NotificationSender {
    @Override
    public String sendNotification(String message) {
        return "Wysyłanie powiadomienia e-mail: " + message;
    }
}