package com.knu.code_competition.code_competition.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class ParticipantAnswerModel implements Serializable {
    private Long id;

    private Long participantId;
    private String participantName;
    private String participantSurname;
    private String participantLogin;

    private Long taskId;
    private String taskName;

    private String option;

}
