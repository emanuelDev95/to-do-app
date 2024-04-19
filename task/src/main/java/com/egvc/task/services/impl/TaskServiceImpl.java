package com.egvc.task.services.impl;

import com.egvc.task.commons.services.impl.AbstractGenericService;
import com.egvc.task.dtos.TaskDto;
import com.egvc.task.mappers.TaskMapper;
import com.egvc.task.persistence.entities.Task;
import com.egvc.task.persistence.repositories.TaskRepository;
import com.egvc.task.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends AbstractGenericService<Task, TaskDto, Long> implements TaskService {

    private static final String NOT_FOUND_STATUS_MESSAGE = "Tarea no encontrada";

    protected TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        super(taskRepository, taskMapper, NOT_FOUND_STATUS_MESSAGE );
    }
}
