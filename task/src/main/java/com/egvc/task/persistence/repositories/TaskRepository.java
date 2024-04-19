package com.egvc.task.persistence.repositories;

import com.egvc.task.persistence.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
