package com.knu.code_competition.code_competition.entity;

import com.knu.code_competition.code_competition.enums.TaskType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "[task]")
public class Task {
    @Id
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "task_seq")
    private Long id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "taskType")
    private TaskType taskType;

    @ManyToOne
    @JoinColumn( name = "competition_id")
    private Competition competition;
}
