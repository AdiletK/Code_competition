package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ParticipantAnswerShortModel {
    private Long id;

    private Long participantId;

    private Long taskId;

    private String option;
}
