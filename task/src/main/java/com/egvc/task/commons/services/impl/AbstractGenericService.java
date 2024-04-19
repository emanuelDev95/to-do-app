package com.egvc.task.commons.services.impl;

import com.egvc.msproducts.commons.entities.AbstractEntity;
import com.egvc.msproducts.commons.mappers.GenericMapper;
import com.egvc.msproducts.commons.services.GenericService;
import com.egvc.msproducts.exceptions.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;


public abstract class AbstractGenericService<E extends AbstractEntity<K>,D,K> implements GenericService<D,K> {

    protected JpaRepository<E,K> repository;
    protected GenericMapper<D,E> mapper;
    protected String notFoundMessage;



    protected AbstractGenericService(JpaRepository<E, K> repository, GenericMapper<D, E> mapper, String notFoundMessage) {
        this.repository = repository;
        this.mapper = mapper;
        this.notFoundMessage = notFoundMessage;
    }


    @Override
    public D save(D dto) {
        var entitie = this.mapper.toEntity(dto);
        this.repository.saveAndFlush(entitie);
        return this.mapper.toDto(entitie);
    }

    @Override
    public List<D> getAll() {

        return this.repository.findAll().stream()
                    .map(this.mapper::toDto)
                    .toList();

    }

    @Override
    public D getById(@NonNull K id) {
       return this.repository.findById(id)
                            .map(this.mapper::toDto)
                            .orElseThrow(() -> new ResourceNotFoundException(this.notFoundMessage));
    }

    @Override
    public void delete(@NonNull K id) {
        this.repository.deleteById(id);
    }

    @Override
    public D update(D dto, K id) {

        if(!this.repository.existsById(id)) {
            throw new ResourceNotFoundException(this.notFoundMessage);
        }
        var entitie = this.mapper.toEntity(dto);
        entitie.setId(id);
        return this.mapper.toDto(this.repository.saveAndFlush(entitie));
    }
}