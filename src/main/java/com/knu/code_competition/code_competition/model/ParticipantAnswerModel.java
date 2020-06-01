package com.knu.code_competition.code_competition.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ParticipantAnswerModel {
    private Long id;

    private Long participantId;
    private String participantName;
    private String participantSurname;
    private String participantLogin;

    private Long taskId;
    private String taskName;

    private String option;

}
