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
    private final AnswerRepo answerRepo;

    public AnswerServiceImpl(TaskService taskService, AnswerRepo answerRepo) {
        this.taskService = taskService;
        this.answerRepo = answerRepo;
    }

    @Override
    public List<AnswerModel> findAll() {
        return answerRepo.getAll();
    }

    @Override
    public Answer getById(Long id) {
        return answerRepo.getOne(id);
    }

    @Override
    public AnswerModel findById(Long id) {
        return answerRepo.getById(id);
    }

    @Override
    public AnswerShortModel create(AnswerShortModel model) {
        Answer answer = new Answer();
        return getAnswerModel(model, answer);
    }

    @Override
    public AnswerShortModel update(Long id, AnswerShortModel model) {
        Answer answer = answerRepo.getOne(id);
        return getAnswerModel(model, answer);
    }

    private AnswerShortModel getAnswerModel(AnswerShortModel model, Answer answer) {
        answer.setOption(model.getOption());
        answer.setTask(taskService.getById(model.getId()));
        answer = answerRepo.save(answer);
        model.setId(answer.getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        answerRepo.deleteById(id);
    }
}
