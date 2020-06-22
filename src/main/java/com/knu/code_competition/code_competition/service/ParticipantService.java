package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Participant;
import com.knu.code_competition.code_competition.model.ParticipantModel;
import com.knu.code_competition.code_competition.model.ParticipantShortModel;

import java.util.List;

public interface ParticipantService {
    List<ParticipantModel> findAll();

    Participant getById(Long id);

    ParticipantModel findById(Long id);

    List<ParticipantModel> findActiveByCompetitionAndUserId(Long userId, Long comId);

    List<ParticipantModel> findByCompetitionAndUserId(Long userId, Long comId);

    List<ParticipantModel> findByCompetitionId(Long id);

    List<ParticipantModel> findByUserId(Long id);

    ParticipantShortModel create(ParticipantShortModel competitionModel);

    ParticipantShortModel update(Long id, ParticipantShortModel competitionModel);

    void delete(Long id);
}
