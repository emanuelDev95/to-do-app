package com.egvc.task.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TaskDto(
        Long id,
        String title,
        String description,
        LocalDateTime due,
        StatusDto status
) {
}
