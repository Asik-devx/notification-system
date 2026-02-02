package com.asik.notification_api.dto;

import jakarta.validation.constraints.NotBlank;

public record NotificationRequest(
        @NotBlank String userId,
        @NotBlank String channel,
        @NotBlank String recipient,
        @NotBlank String message,
        @NotBlank String idempotencyKey
) {}
