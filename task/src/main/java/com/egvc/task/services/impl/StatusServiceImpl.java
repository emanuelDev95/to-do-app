package com.egvc.task.services.impl;

import com.egvc.task.commons.services.impl.AbstractGenericService;
import com.egvc.task.dtos.StatusDto;
import com.egvc.task.mappers.StatusMapper;
import com.egvc.task.persistence.entities.Status;
import com.egvc.task.persistence.repositories.StatusRepository;
import com.egvc.task.services.StatusService;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl extends AbstractGenericService<Status, StatusDto, Long> implements StatusService {


    private static final String NOT_FOUND_STATUS_MESSAGE = "Estado no encontrado";

    protected StatusServiceImpl(StatusRepository statusRepository, StatusMapper statusMapper) {
        super(statusRepository, statusMapper, NOT_FOUND_STATUS_MESSAGE);
    }
}
