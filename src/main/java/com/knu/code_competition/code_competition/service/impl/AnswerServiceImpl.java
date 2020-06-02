package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.entity.Answer;
import com.knu.code_competition.code_competition.model.AnswerModel;
import com.knu.code_competition.code_competition.model.AnswerShortModel;
import com.knu.code_competition.code_competition.repository.AnswerRepo;
import com.knu.code_competition.code_competition.service.AnswerService;
import com.knu.code_competition.code_competition.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final TaskService taskService;
    private final AnswerRepo optionRepo;

    public AnswerServiceImpl(TaskService taskService, AnswerRepo optionRepo) {
        this.taskService = taskService;
        this.optionRepo = optionRepo;
    }

    @Override
    public List<AnswerModel> findAll() {
        return optionRepo.getAll();
    }

    @Override
    public Answer getById(Long id) {
        return optionRepo.getOne(id);
    }

    @Override
    public AnswerModel findById(Long id) {
        return optionRepo.getById(id);
    }

    @Override
    public AnswerShortModel create(AnswerShortModel model) {
        Answer answer = new Answer();
        return getAnswerModel(model, answer);
    }

    @Override
    public AnswerShortModel update(Long id, AnswerShortModel model) {
        Answer answer = optionRepo.getOne(id);
        return getAnswerModel(model, answer);
    }

    private AnswerShortModel getAnswerModel(AnswerShortModel model, Answer answer) {
        answer.setAnswer(model.getOption());
        answer.setTask(taskService.getById(model.getTaskId()));
        answer = optionRepo.save(answer);
        model.setId(answer.getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        optionRepo.deleteById(id);
    }
}
