package com.knu.code_competition.code_competition.model;

import com.knu.code_competition.code_competition.enums.TaskType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TaskShortModel implements Serializable {
    private Long id;

    private String description;

    private TaskType taskType;

    private Long competitionId;
}
