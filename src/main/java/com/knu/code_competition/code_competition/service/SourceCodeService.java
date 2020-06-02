package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.SourceCode;
import com.knu.code_competition.code_competition.model.SourceCodeModel;
import com.knu.code_competition.code_competition.model.SourceCodeShortModel;

import java.util.List;

public interface SourceCodeService {
    List<SourceCodeModel> findAll();

    SourceCode getById(Long id);

    SourceCodeModel findById(Long id);

    SourceCodeShortModel create(SourceCodeShortModel model);

    SourceCodeShortModel update(Long id, SourceCodeShortModel model);

    void delete(Long id);
}
