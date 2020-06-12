package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.entity.ParticipantAnswer;
import com.knu.code_competition.code_competition.model.ParticipantAnswerModel;
import com.knu.code_competition.code_competition.model.ParticipantAnswerShortModel;
import com.knu.code_competition.code_competition.repository.ParticipantAnswerRepo;
import com.knu.code_competition.code_competition.service.ParticipantService;
import com.knu.code_competition.code_competition.service.ParticipantAnswerService;
import com.knu.code_competition.code_competition.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantAnswerServiceImpl implements ParticipantAnswerService {
    private final TaskService taskService;
    private final ParticipantService participantService;
    private final ParticipantAnswerRepo participantAnswerRepo;

    public ParticipantAnswerServiceImpl(TaskService taskService, ParticipantService participantService, ParticipantAnswerRepo participantAnswerRepo) {
        this.taskService = taskService;
        this.participantService = participantService;
        this.participantAnswerRepo = participantAnswerRepo;
    }

    @Override
    public List<ParticipantAnswerModel> findAll() {
        return participantAnswerRepo.getAll();
    }

    @Override
    public ParticipantAnswer getById(Long id) {
        return participantAnswerRepo.getOne(id);
    }

    @Override
    public List<ParticipantAnswerModel> getByTaskId(Long id) {
        return participantAnswerRepo.getByTaskId(id);
    }

    @Override
    public List<ParticipantAnswerModel> getByParticipantId(Long id) {
        return participantAnswerRepo.getByParticipantId(id);
    }

    @Override
    public List<ParticipantAnswerShortModel> getShortByParticipantId(Long id) {
        return participantAnswerRepo.getShortByParticipantId(id);
    }

    @Override
    public ParticipantAnswerModel findById(Long id) {
        return participantAnswerRepo.getById(id);
    }

    @Override
    public ParticipantAnswerShortModel create(ParticipantAnswerShortModel model) {
        ParticipantAnswer root = new ParticipantAnswer();
        return getParticipantAnswerModel(model, root);
    }

    @Override
    public ParticipantAnswerShortModel update(Long id, ParticipantAnswerShortModel model) {
        ParticipantAnswer root = participantAnswerRepo.getOne(id);
        return getParticipantAnswerModel(model, root);
    }

    private ParticipantAnswerShortModel getParticipantAnswerModel(ParticipantAnswerShortModel model, ParticipantAnswer root) {
        root.setOption(model.getOption());
        root.setTask(taskService.getById(model.getTaskId()));
        root.setParticipant(participantService.getById(model.getParticipantId()));
        root.setIsCorrect(model.getIsCorrect());
        root = participantAnswerRepo.save(root);
        model.setId(root.getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        participantAnswerRepo.deleteById(id);
    }
}
