package com.egvc.task.commons.mappers;


import com.egvc.task.commons.entities.AbstractEntity;

public interface GenericMapper<D,E extends AbstractEntity> {

    E toEntity(D dto);

    D toDto(E entity);


}