package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Test;
import com.knu.code_competition.code_competition.model.TestModel;

import java.util.List;

public interface TestService {
    List<TestModel> findAll();

    List<TestModel> findAllBySourceCodeId(Long sourceCodeId);

    Test getById(Long id);

    TestModel findById(Long id);

    TestModel create(TestModel model);

    TestModel update(Long id, TestModel model);

    void delete(Long id);
}
