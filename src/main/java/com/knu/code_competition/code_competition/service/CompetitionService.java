package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Competition;
import com.knu.code_competition.code_competition.model.CompetitionModel;
import com.knu.code_competition.code_competition.model.CompetitionShortModel;

import java.util.List;

public interface CompetitionService {
    List<CompetitionModel> findAll();

    Competition getById(Long id);

    CompetitionModel findById(Long id);

    CompetitionShortModel create(CompetitionShortModel competitionModel);

    CompetitionShortModel update(Long id, CompetitionShortModel competitionModel);

    void delete(Long id);
}
