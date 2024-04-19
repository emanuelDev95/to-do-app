package com.egvc.task.mappers;

import com.egvc.task.commons.mappers.GenericMapper;
import com.egvc.task.dtos.StatusDto;
import com.egvc.task.dtos.TaskDto;
import com.egvc.task.persistence.entities.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements GenericMapper<TaskDto, Task> {

    @Override
    public Task toEntity(TaskDto dto) {
        var task = new Task();
        task.setId(dto.id());
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setDue(dto.due());
        return task;
    }

    @Override
    public TaskDto toDto(Task entity) {
        return TaskDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .due(entity.getDue())
                .status(StatusDto.builder()
                        .id(entity.getStatus().getId())
                        .status(entity.getStatus().getStatus())
                        .build())
                .build();
    }
}
