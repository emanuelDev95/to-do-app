package com.egvc.task.mappers;

import com.egvc.task.commons.mappers.GenericMapper;
import com.egvc.task.dtos.StatusDto;
import com.egvc.task.persistence.entities.Status;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper implements GenericMapper<StatusDto, Status> {
    @Override
    public Status toEntity(StatusDto dto) {
        var status = new Status();
        status.setId(dto.id());
        status.setStatus(dto.status());
        return status;
    }

    @Override
    public StatusDto toDto(Status entity) {
        return StatusDto.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .build();
    }
}
