package com.egvc.task.persistence.entities;

import com.egvc.task.commons.entities.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Tasks")
public class Task extends AbstractEntity<Long> {
    private static final long serialVersionUID = 1L;
    private String title;
    private String description;
    private Date due;
    @ManyToOne
    private Status status;
}
