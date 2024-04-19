package com.egvc.task.dtos;

import lombok.Builder;

@Builder
public record MessageResponse<D>
        (String message,
         Integer statusCode,
         D data) {
}
