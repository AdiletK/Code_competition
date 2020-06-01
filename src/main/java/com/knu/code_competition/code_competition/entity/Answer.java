package com.knu.code_competition.code_competition.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @SequenceGenerator(name = "answer_seq", sequenceName = "answer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_seq")
    private Long id;

    @Column(name = "option")
    private String option;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "isCorrect")
    private Boolean isCorrect;
}
