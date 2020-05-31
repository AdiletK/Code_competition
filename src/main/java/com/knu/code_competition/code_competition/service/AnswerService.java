package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Answer;
import com.knu.code_competition.code_competition.model.AnswerModel;
import com.knu.code_competition.code_competition.model.AnswerShortModel;

import java.util.List;

public interface AnswerService {
    List<AnswerModel> findAll();

    Answer getById(Long id);

    AnswerModel findById(Long id);

    AnswerShortModel create(AnswerShortModel model);

    AnswerShortModel update(Long id, AnswerShortModel model);

    void delete(Long id);
}
