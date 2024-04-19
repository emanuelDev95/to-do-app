package com.egvc.task.persistence.repositories;

import com.egvc.task.persistence.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatusRepository extends JpaRepository<Status, Long> {
}
