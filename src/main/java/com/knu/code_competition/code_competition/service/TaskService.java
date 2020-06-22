package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Task;
import com.knu.code_competition.code_competition.enums.TaskType;
import com.knu.code_competition.code_competition.model.TaskModel;
import com.knu.code_competition.code_competition.model.TaskShortModel;

import java.util.List;

public interface TaskService {
    List<TaskModel> findAll();

    List<TaskModel> findAllByCompetitionId(Long compId);

    Task getById(Long id);

    TaskModel findById(Long id);

    TaskShortModel create(TaskShortModel competitionModel);

    TaskShortModel update(Long id, TaskShortModel competitionModel);

    TaskType[] taskTypes();

    void delete(Long id);
}
