package com.asik.notification_worker.consumer;

import com.asik.common.event.NotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {

    @KafkaListener(
            topics = "notifications",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(NotificationEvent event) {
        log.info("📩 Received notification: {}", event);
    }
}
