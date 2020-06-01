package com.knu.code_competition.code_competition.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "participant_answer")
public class ParticipantAnswer {
    @Id
    @SequenceGenerator(name = "participant_answer_seq", sequenceName = "participant_answer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participant_answer_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "option")
    private String option;

}
