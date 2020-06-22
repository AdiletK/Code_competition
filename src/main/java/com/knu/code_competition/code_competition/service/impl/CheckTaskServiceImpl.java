package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.Utils.RecordNotFoundException;
import com.knu.code_competition.code_competition.entity.Task;
import com.knu.code_competition.code_competition.enums.TaskType;
import com.knu.code_competition.code_competition.model.*;
import com.knu.code_competition.code_competition.service.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckTaskServiceImpl implements CheckTaskService {
    private final TaskService taskService;
    private final ParticipantService participantService;
    private final ParticipantAnswerService participantAnswerService;
    private final AnswerService answerService;
    private final OptionService optionService;

    public CheckTaskServiceImpl(TaskService taskService, ParticipantService participantService, ParticipantAnswerService participantAnswerService, AnswerService answerService, OptionService optionService, SourceCodeService sourceCodeService) {
        this.taskService = taskService;
        this.participantService = participantService;
        this.participantAnswerService = participantAnswerService;
        this.answerService = answerService;
        this.optionService = optionService;
    }

    @Override
    public ResponseCheckModel checkAll() {

        return null;
    }

    @Override
    public List<ResponseCheckModel> checkByCompetitionId(Long compId) {
        List<ResponseCheckModel> responseCheckModels = new ArrayList<>();
        List<ParticipantModel> participantModels = participantService.findByCompetitionId(compId);
        return getResponseCheckModels(responseCheckModels, participantModels);
    }

    @Override
    public List<ResponseCheckModel> checkByUserId(Long userId) {
        List<ResponseCheckModel> responseCheckModels = new ArrayList<>();
        List<ParticipantModel> participantModels = participantService.findByUserId(userId);
        return getResponseCheckModels(responseCheckModels, participantModels);
    }

    @Override
    public List<ResponseCheckModel> checkByUserAndCompetitionId(Long userId, Long compId) {
        List<ResponseCheckModel> responseCheckModels = new ArrayList<>();
        List<ParticipantModel> participantModels = participantService.findByCompetitionAndUserId(compId, userId);
        return getResponseCheckModels(responseCheckModels, participantModels);
    }

    private List<ResponseCheckModel> getResponseCheckModels(List<ResponseCheckModel> responseCheckModels, List<ParticipantModel> participantModels) {
        if (participantModels.isEmpty()){
            throw new RecordNotFoundException("Data not found!");
        }
        for (ParticipantModel participantModel : participantModels){
            ResponseCheckModel responseCheckModel = new ResponseCheckModel();
            List<DetailCheckResponse> detailCheckResponses = new ArrayList<>();
            List<ParticipantAnswerShortModel> answerModel = participantAnswerService.getShortByParticipantId(participantModel.getId());
            int correct = 0;
            for (ParticipantAnswerShortModel model : answerModel) {
                DetailCheckResponse detailCheckResponse = new DetailCheckResponse();
                detailCheckResponse.setParticipantAnswer(model.getOption());
                Task task = taskService.getById(model.getTaskId());
                detailCheckResponse.setTaskDescription(task.getDescription());

                if (task.getTaskType() == TaskType.ANSWER)
                    detailCheckResponse.setCorrectAnswer(answerService.findByTaskId(model.getTaskId()).getOption());
                else if (task.getTaskType() == TaskType.ANSWERS){
                    List<OptionModel> list = optionService.findAllByTaskId(model.getTaskId());
                    for (OptionModel option : list) {
                        if (option.getIsCorrect())
                            detailCheckResponse.setCorrectAnswer(option.getOption());
                    }
                }
                detailCheckResponses.add(detailCheckResponse);
                if (model.getIsCorrect()) {
                    correct++;
                }
            }
            responseCheckModel.setParticipantName(participantModel.getUserName() + " " + participantModel.getUserSurname());

            responseCheckModel.setCorrectAnswersCount(correct);

            List<TaskModel> taskModels = taskService.findAllByCompetitionId(participantModel.getCompetitionId());
            System.out.println(taskModels);
            responseCheckModel.setTasksCount(taskModels.size());

            responseCheckModel.setDetailCheckResponses(detailCheckResponses);

            responseCheckModels.add(responseCheckModel);
        }
        return responseCheckModels;
    }

    //old version
    @Override
    public CheckTaskModel checkTask(Long userId, Long competitionId) {
        ParticipantModel participantModel = participantService.findActiveByCompetitionAndUserId(userId, competitionId).get(0);
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
