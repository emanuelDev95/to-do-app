package com.egvc.task.controllers.rest;

import com.egvc.task.dtos.StatusDto;
import com.egvc.task.dtos.responses.MessageResponse;
import com.egvc.task.services.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @GetMapping
    public ResponseEntity<MessageResponse<List<StatusDto>>>getStatus() {
        return ResponseEntity.ok(MessageResponse.<List<StatusDto>>builder()
                .data(statusService.getAll())
                .statusCode(HttpStatus.OK.value())
                .message("OK")
                .build());
    }
}
