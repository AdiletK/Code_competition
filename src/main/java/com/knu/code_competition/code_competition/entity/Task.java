package com.knu.code_competition.code_competition.entity;

import javax.persistence.*;

@Entity
@Table(name = "[task]")
public class Task {
    @Id
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "task_seq")
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TaskType taskType;

    @ManyToOne
    @JoinColumn( name = "competition_id")
    private Competition competition;
}
