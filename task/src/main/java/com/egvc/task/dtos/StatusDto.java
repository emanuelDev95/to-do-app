package com.egvc.task.dtos;

import lombok.Builder;

@Builder
public record StatusDto(
        Long id,
        String status
) {
}
