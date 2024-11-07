package com.example.notification;

public class SMSNotificationSender extends NotificationSender {
    @Override
    public String sendNotification(String message) {
        return "Wysyłanie powiadomienia SMS: " + message;
    }
}