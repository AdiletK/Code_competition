package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.ParticipantAnswer;
import com.knu.code_competition.code_competition.model.ParticipantAnswerModel;
import com.knu.code_competition.code_competition.model.ParticipantAnswerShortModel;

import java.util.List;

public interface ParticipantAnswerService {
    List<ParticipantAnswerModel> findAll();

    ParticipantAnswer getById(Long id);

    ParticipantAnswerModel findById(Long id);

    ParticipantAnswerShortModel create(ParticipantAnswerShortModel competitionModel);

    ParticipantAnswerShortModel update(Long id, ParticipantAnswerShortModel competitionModel);

    void delete(Long id);
}
