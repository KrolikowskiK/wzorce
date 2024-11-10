package com.example.notification;

public class NotificationService {
    public void notifyCustomer(String message, NotificationSender notificationSender) {
        notificationSender.sendNotification(message);
    }
}
