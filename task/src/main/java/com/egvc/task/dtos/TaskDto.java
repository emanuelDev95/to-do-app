package com.egvc.task.dtos;

import lombok.Builder;

import java.util.Date;

@Builder
public record TaskDto(
        Long id,
        String title,
        String description,
        Date due,
        StatusDto status
) {
}
