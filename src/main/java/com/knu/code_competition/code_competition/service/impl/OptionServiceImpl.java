package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.entity.Option;
import com.knu.code_competition.code_competition.model.OptionModel;
import com.knu.code_competition.code_competition.model.OptionShortModel;
import com.knu.code_competition.code_competition.repository.OptionRepo;
import com.knu.code_competition.code_competition.service.OptionService;
import com.knu.code_competition.code_competition.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {
    private final TaskService taskService;
    private final OptionRepo optionRepo;

    public OptionServiceImpl(TaskService taskService, OptionRepo optionRepo) {
        this.taskService = taskService;
        this.optionRepo = optionRepo;
    }

    @Override
    public List<OptionModel> findAll() {
        return optionRepo.getAll();
    }

    @Override
    public Option getById(Long id) {
        return optionRepo.getOne(id);
    }

    @Override
    public OptionModel findById(Long id) {
        return optionRepo.getById(id);
    }

    @Override
    public OptionShortModel create(OptionShortModel model) {
        Option option = new Option();
        return getAnswerModel(model, option);
    }

    @Override
    public OptionShortModel update(Long id, OptionShortModel model) {
        Option option = optionRepo.getOne(id);
        return getAnswerModel(model, option);
    }

    private OptionShortModel getAnswerModel(OptionShortModel model, Option option) {
        option.setOption(model.getOption());
        option.setTask(taskService.getById(model.getTaskId()));
        option.setIsCorrect(model.getIsCorrect());
        option = optionRepo.save(option);
        model.setId(option.getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        optionRepo.deleteById(id);
    }
}
