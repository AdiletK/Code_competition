package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Competition;
import com.knu.code_competition.code_competition.model.CompetitionModel;

import java.util.List;

public interface CompetitionService {
    List<CompetitionModel> findAll();

    Competition getById(Long id);

    CompetitionModel findById(Long id);

    CompetitionModel create(CompetitionModel competitionModel);

    CompetitionModel update(Long id, CompetitionModel competitionModel);

    void delete(Long id);
}
