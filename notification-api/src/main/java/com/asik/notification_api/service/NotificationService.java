package com.asik.notification_api.service;

import com.asik.common.event.NotificationEvent;
import com.asik.notification_api.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private static final String TOPIC = "notifications";

    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    public void send(NotificationRequest request) {
        NotificationEvent event = new NotificationEvent(
                UUID.randomUUID(),
                request.userId(),
                request.channel(),
                request.recipient(),
                request.message(),
                request.idempotencyKey(),
                Instant.now()
        );

        // Key = userId → ordering guarantee
        kafkaTemplate.send(TOPIC, request.userId(), event);
    }
}
