package com.knu.code_competition.code_competition.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "task_type")
public class TaskType {
    @Id
    @SequenceGenerator(name = "task_type_seq", sequenceName = "task_type_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "task_type_seq")
    private Long id;

    @Column(name="name", length=50, nullable=false)
    private String name;
}
