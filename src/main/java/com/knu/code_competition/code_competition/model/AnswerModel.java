package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AnswerModel {
    private Long id;

    private String option;

    private Long taskId;
    private String taskName;

    public AnswerModel(Long id, String option, Long taskId, String taskName) {
        this.id = id;
        this.option = option;
        this.taskId = taskId;
        this.taskName = taskName;
    }
}
