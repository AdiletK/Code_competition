package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class OptionModel implements Serializable {
    private Long id;

    private String option;

    private Long taskId;
    private String taskName;
    private Boolean isCorrect;
}
