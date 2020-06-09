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
@Table(name = "answer")
public class Answer {
    @Id
    @SequenceGenerator(name = "answer_seq", sequenceName = "answer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_seq")
    private Long id;

    @Column(name = "answer")
    private String answer;

    @OneToOne
    @JoinColumn(name = "task_id", unique = true)
    private Task task;

}
