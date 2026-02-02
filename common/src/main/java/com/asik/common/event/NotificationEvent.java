package com.asik.common.event;

import java.time.Instant;
import java.util.UUID;

public record NotificationEvent(
        UUID eventId,
        String userId,
        String channel,
        String recipient,
        String message,
        String idempotencyKey,
        Instant createdAt
) {}
