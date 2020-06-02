package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Option;
import com.knu.code_competition.code_competition.model.OptionModel;
import com.knu.code_competition.code_competition.model.OptionShortModel;

import java.util.List;

public interface OptionService {
    List<OptionModel> findAll();

    Option getById(Long id);

    OptionModel findById(Long id);

    OptionShortModel create(OptionShortModel model);

    OptionShortModel update(Long id, OptionShortModel model);

    void delete(Long id);
}
