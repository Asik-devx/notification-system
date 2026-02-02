package com.asik.notification_api.controller;

import com.asik.notification_api.dto.NotificationRequest;
import com.asik.notification_api.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public ResponseEntity<Void> send(
            @RequestBody @Valid NotificationRequest request
    ) {
        service.send(request);
        return ResponseEntity.accepted().build();
    }
}
