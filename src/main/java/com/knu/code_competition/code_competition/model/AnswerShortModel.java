package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class AnswerShortModel implements Serializable {
    private Long id;

    private String option;

    private Long taskId;

    private Boolean isCorrect;
}
