package com.knu.code_competition.code_competition.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "source_code", uniqueConstraints = {@UniqueConstraint(columnNames = {"task_id"})})
public class SourceCode {
    @Id
    @SequenceGenerator(name = "source_code_seq", sequenceName = "source_code_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "source_code_seq")
    private Long id;

    @Column(name = "time_limit")
    private Float time;

    @Column(name = "memory_limit")
    private Float memory;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "task_id", unique = true)
    private Task task;

}
