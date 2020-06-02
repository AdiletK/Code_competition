package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.entity.Test;
import com.knu.code_competition.code_competition.model.TestModel;
import com.knu.code_competition.code_competition.repository.TestRepo;
import com.knu.code_competition.code_competition.service.TestService;
import com.knu.code_competition.code_competition.service.SourceCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final SourceCodeService sourceCodeService;
    private final TestRepo optionRepo;

    public TestServiceImpl(SourceCodeService sourceCodeService, TestRepo optionRepo) {
        this.sourceCodeService = sourceCodeService;
        this.optionRepo = optionRepo;
    }

    @Override
    public List<TestModel> findAll() {
        return optionRepo.getAll();
    }

    @Override
    public Test getById(Long id) {
        return optionRepo.getOne(id);
    }

    @Override
    public TestModel findById(Long id) {
        return optionRepo.getById(id);
    }

    @Override
    public TestModel create(TestModel model) {
        Test test = new Test();
        return getAnswerModel(model, test);
    }

    @Override
    public TestModel update(Long id, TestModel model) {
        Test test = optionRepo.getOne(id);
        return getAnswerModel(model, test);
    }

    private TestModel getAnswerModel(TestModel model, Test test) {
        test.setInput(model.getInput());
        test.setOutput(model.getOutput());
        test.setSourceCode(sourceCodeService.getById(model.getSourceCodeId()));
        test = optionRepo.save(test);
        model.setId(test.getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        optionRepo.deleteById(id);
    }
}
