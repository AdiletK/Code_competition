package com.knu.code_competition.code_competition.model;

import com.knu.code_competition.code_competition.enums.TaskType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TaskModel {
    private Long id;

    private String description;

    private TaskType taskType;

    private Long competitionId;
    private String competitionName;

    public TaskModel(Long id, String description, TaskType taskType, Long competitionId, String competitionName) {
        this.id = id;
        this.description = description;
        this.taskType = taskType;
        this.competitionId = competitionId;
        this.competitionName = competitionName;
    }
}
