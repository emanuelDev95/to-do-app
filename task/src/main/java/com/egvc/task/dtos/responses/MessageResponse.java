package com.egvc.task.dtos.responses;

import lombok.Builder;

@Builder
public record MessageResponse<D>
        (String message,
         Integer statusCode,
         D data) {
}
