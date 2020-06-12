package com.knu.code_competition.code_competition.model;

import com.knu.code_competition.code_competition.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class TaskModel implements Serializable {
    private Long id;

    private String description;

    private TaskType taskType;

    private Long competitionId;
    private String competitionName;

}
