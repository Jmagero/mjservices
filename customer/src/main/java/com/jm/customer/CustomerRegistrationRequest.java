package com.jm.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
