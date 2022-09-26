package com.jm.fraud;

import java.time.LocalDateTime;

public record CheckFraudRequest(
        Integer customerId,
        Boolean isFraudster,
        LocalDateTime createdAt) {
}
