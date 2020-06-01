package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class AnswerModel {
    private Long id;

    private String option;

    private Long taskId;
    private String taskName;

}
