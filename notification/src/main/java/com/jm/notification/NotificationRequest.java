package com.jm.notification;

public record NotificationRequest (
        Integer toCustomerId,
        String toCustomerEmail,
        String message
){
}
