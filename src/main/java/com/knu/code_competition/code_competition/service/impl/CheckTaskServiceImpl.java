package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.model.*;
import com.knu.code_competition.code_competition.service.*;

import java.util.List;

public class CheckTaskServiceImpl implements CheckTaskService {
    private final TaskService taskService;
    private final ParticipantService participantService;
    private final ParticipantAnswerService participantAnswerService;
    private final AnswerService answerService;
    private final OptionService optionService;
    private final SourceCodeService sourceCodeService;

    public CheckTaskServiceImpl(TaskService taskService, ParticipantService participantService, ParticipantAnswerService participantAnswerService, AnswerService answerService, OptionService optionService, SourceCodeService sourceCodeService) {
        this.taskService = taskService;
        this.participantService = participantService;
        this.participantAnswerService = participantAnswerService;
        this.answerService = answerService;
        this.optionService = optionService;
        this.sourceCodeService = sourceCodeService;
    }

    @Override
    public CheckTaskModel checkTask(Long userId, Long competitionId) {
        ParticipantModel participantModel = participantService.findByCompetitionAndUserId(userId, competitionId).get(0);
        CheckTaskModel checkTaskModel = new CheckTaskModel();
        if (participantModel != null) {
            List<ParticipantAnswerModel> answerModel = participantAnswerService.getByParticipantId(participantModel.getId());
            int correct = 0;
            int incorrect = 0;
            checkTaskModel.setTaskCount(answerModel.size());
            for (ParticipantAnswerModel model : answerModel) {
                TaskModel taskModel = taskService.findById(model.getTaskId());
                switch (taskModel.getTaskType()){
                    case ANSWER:
                        AnswerModel answerModel1 = answerService.findById(model.getTaskId());
                        if (answerModel1.getOption().toLowerCase().equals(model.getOption().toLowerCase()))
                            correct++;
                        else
                            incorrect--;
                        break;
                    case ANSWERS:
                        OptionModel optionModel = optionService.findById(model.getTaskId());
                        if (optionModel.getOption().toLowerCase().equals(model.getOption().toLowerCase()))
                            correct++;
                        else
                            incorrect--;
                        break;
                }
            }
            checkTaskModel.setCorrect(correct);
            checkTaskModel.setIncorrect(incorrect);
        }
        return checkTaskModel;
    }
}
