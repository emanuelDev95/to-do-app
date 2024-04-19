package com.egvc.task.commons.services;

import org.springframework.lang.NonNull;

import java.util.List;

public interface GenericService <D, K> {

    D save(D dto);

    List<D> getAll();

    D getById(@NonNull K id);

    void delete(@NonNull K id);

    D update(D dto, K id);

    
}