package com.egvc.task.persistence.entities;

import com.egvc.task.commons.entities.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity @Table(name = "Statuses")
@Data @NoArgsConstructor
@AllArgsConstructor @Builder
@EqualsAndHashCode(callSuper = true)
public class Status extends AbstractEntity<Long> {
    private static final long serialVersionUID = 1L;

    @Column( name = "estado")
    private String status;

}
