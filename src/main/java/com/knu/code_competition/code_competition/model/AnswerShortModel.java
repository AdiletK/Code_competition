package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AnswerShortModel {
    private Long id;

    private String option;

    private Long taskId;
}
