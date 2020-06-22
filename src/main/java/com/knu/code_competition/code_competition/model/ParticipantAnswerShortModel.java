package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class ParticipantAnswerShortModel implements Serializable {
    private Long id;

    private Long participantId;

    private Long taskId;

    private Boolean isCorrect;

    private String option;

    public ParticipantAnswerShortModel(Long id, Long taskId, Boolean isCorrect, String option) {
        this.id = id;
        this.taskId = taskId;
        this.isCorrect = isCorrect;
        this.option = option;
    }
}
