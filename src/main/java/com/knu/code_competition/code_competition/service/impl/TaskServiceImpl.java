package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.entity.Task;
import com.knu.code_competition.code_competition.enums.TaskType;
import com.knu.code_competition.code_competition.model.TaskModel;
import com.knu.code_competition.code_competition.model.TaskShortModel;
import com.knu.code_competition.code_competition.repository.TaskRepo;
import com.knu.code_competition.code_competition.service.TaskService;
import com.knu.code_competition.code_competition.service.CompetitionService;
import com.knu.code_competition.code_competition.service.TaskService;
import com.knu.code_competition.code_competition.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final CompetitionService competitionService;
    private final TaskRepo taskRepo;

    public TaskServiceImpl(CompetitionService competitionService, TaskRepo taskRepo) {
        this.competitionService = competitionService;
        this.taskRepo = taskRepo;
    }

    @Override
    public List<TaskModel> findAll() {
        return taskRepo.getAll();
    }

    @Override
    public List<TaskModel> findAllByCompetitionId(Long compId) {
        return taskRepo.getAllByTaskId(compId);
    }

    @Override
    public Task getById(Long id) {
        return taskRepo.getOne(id);
    }

    @Override
    public TaskModel findById(Long id) {
        return taskRepo.findTaskById(id);
    }

    @Override
    public TaskShortModel create(TaskShortModel model) {
        Task task = new Task();
        return getTaskModel(model, task);
    }

    @Override
    public TaskShortModel update(Long id, TaskShortModel model) {
        Task task = taskRepo.getOne(id);
        return getTaskModel(model, task);
    }

    @Override
    public TaskType[] taskTypes() {
        return TaskType.values();
    }

    private TaskShortModel getTaskModel(TaskShortModel model, Task task) {
        task.setTaskType(model.getTaskType());
        task.setDescription(model.getDescription());
        task.setCompetition(competitionService.getById(model.getCompetitionId()));
        task = taskRepo.save(task);
        model.setId(task.getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        taskRepo.deleteById(id);
    }
}
