package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.entity.Competition;
import com.knu.code_competition.code_competition.model.CompetitionModel;
import com.knu.code_competition.code_competition.repository.CompetitionRepo;
import com.knu.code_competition.code_competition.service.CompetitionService;
import com.knu.code_competition.code_competition.service.SubjectService;
import com.knu.code_competition.code_competition.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    private final UserService userService;
    private final SubjectService subjectService;
    private final CompetitionRepo competitionRepo;

    public CompetitionServiceImpl(UserService userService, SubjectService subjectService, CompetitionRepo competitionRepo) {
        this.userService = userService;
        this.subjectService = subjectService;
        this.competitionRepo = competitionRepo;
    }

    @Override
    public List<CompetitionModel> findAll() {
        return competitionRepo.getAll();
    }

    @Override
    public Competition getById(Long id) {
        return competitionRepo.getOne(id);
    }

    @Override
    public CompetitionModel findById(Long id) {
        return competitionRepo.findCompetitionById(id);
    }

    @Override
    public CompetitionModel create(CompetitionModel model) {
        Competition c = new Competition();
        return getCompetitionModel(model, c);
    }

    @Override
    public CompetitionModel update(Long id, CompetitionModel model) {
        Competition c = competitionRepo.getOne(id);
        return getCompetitionModel(model, c);
    }

    private CompetitionModel getCompetitionModel(CompetitionModel model, Competition c) {
        c.setName(model.getName());
        c.setSubject(subjectService.findById(model.getSubjectId()));
        c.setUser(userService.getCurrentUserId());
        c.setStart_date(model.getStart_date());
        c.setEnd_date(model.getEnd_date());
        c = competitionRepo.save(c);
        model.setId(c.getId());
        model.setUserId(c.getUser().getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        competitionRepo.deleteById(id);
    }
}
