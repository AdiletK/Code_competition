package com.knu.code_competition.code_competition.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "option")
public class Option {
    @Id
    @SequenceGenerator(name = "option_seq", sequenceName = "option_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "option_seq")
    private Long id;

    @Column(name = "option")
    private String option;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "isCorrect")
    private Boolean isCorrect = false;
}
