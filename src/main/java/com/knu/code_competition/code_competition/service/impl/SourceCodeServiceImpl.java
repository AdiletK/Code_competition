package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.entity.SourceCode;
import com.knu.code_competition.code_competition.model.SourceCodeModel;
import com.knu.code_competition.code_competition.model.SourceCodeShortModel;
import com.knu.code_competition.code_competition.repository.SourceCodeRepo;
import com.knu.code_competition.code_competition.service.SourceCodeService;
import com.knu.code_competition.code_competition.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceCodeServiceImpl implements SourceCodeService {
    private final TaskService taskService;
    private final SourceCodeRepo sourceCodeRepo;

    public SourceCodeServiceImpl(TaskService taskService, SourceCodeRepo sourceCodeRepo) {
        this.taskService = taskService;
        this.sourceCodeRepo = sourceCodeRepo;
    }

    @Override
    public List<SourceCodeModel> findAll() {
        return sourceCodeRepo.getAll();
    }

    @Override
    public SourceCode getById(Long id) {
        return sourceCodeRepo.getOne(id);
    }

    @Override
    public SourceCodeModel findById(Long id) {
        return sourceCodeRepo.getById(id);
    }

    @Override
    public SourceCodeModel findByTaskId(Long taskId) {
        return sourceCodeRepo.getByTaskId(taskId);
    }

    @Override
    public SourceCodeShortModel create(SourceCodeShortModel model) {
        SourceCode sourceCode = new SourceCode();
        return getSourceCodeModel(model, sourceCode);
    }

    @Override
    public SourceCodeShortModel update(Long id, SourceCodeShortModel model) {
        SourceCode sourceCode = sourceCodeRepo.getOne(id);
        return getSourceCodeModel(model, sourceCode);
    }

    private SourceCodeShortModel getSourceCodeModel(SourceCodeShortModel model, SourceCode sourceCode) {
        sourceCode.setMemory(model.getMemory());
        sourceCode.setTime(model.getTime());
        sourceCode.setTask(taskService.getById(model.getTaskId()));
        sourceCode = sourceCodeRepo.save(sourceCode);
        model.setId(sourceCode.getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        sourceCodeRepo.deleteById(id);
    }
}
