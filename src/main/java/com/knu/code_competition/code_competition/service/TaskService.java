package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Task;
import com.knu.code_competition.code_competition.model.TaskModel;
import com.knu.code_competition.code_competition.model.TaskShortModel;

import java.util.List;

public interface TaskService {
    List<TaskModel> findAll();

    Task getById(Long id);

    TaskModel findById(Long id);

    TaskShortModel create(TaskShortModel competitionModel);

    TaskShortModel update(Long id, TaskShortModel competitionModel);

    void delete(Long id);
}
