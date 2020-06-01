package com.knu.code_competition.code_competition.model;

import com.knu.code_competition.code_competition.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class TaskModel {
    private Long id;

    private String description;

    private TaskType taskType;

    private Long competitionId;
    private String competitionName;

}
