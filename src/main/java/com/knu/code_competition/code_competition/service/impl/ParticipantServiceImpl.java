package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.entity.Participant;
import com.knu.code_competition.code_competition.model.ParticipantModel;
import com.knu.code_competition.code_competition.model.ParticipantShortModel;
import com.knu.code_competition.code_competition.repository.ParticipantRepo;
import com.knu.code_competition.code_competition.service.ParticipantService;
import com.knu.code_competition.code_competition.service.ParticipantService;
import com.knu.code_competition.code_competition.service.CompetitionService;
import com.knu.code_competition.code_competition.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    private final UserService userService;
    private final CompetitionService competitionService;
    private final ParticipantRepo participantRepo;

    public ParticipantServiceImpl(UserService userService, CompetitionService competitionService, ParticipantRepo participantRepo) {
        this.userService = userService;
        this.competitionService = competitionService;
        this.participantRepo = participantRepo;
    }

    @Override
    public List<ParticipantModel> findAll() {
        return participantRepo.getAll();
    }

    @Override
    public Participant getById(Long id) {
        return participantRepo.getOne(id);
    }

    @Override
    public ParticipantModel findById(Long id) {
        return participantRepo.getById(id);
    }

    @Override
    public List<ParticipantModel> findByCompetitionAndUserId(Long userId, Long comId) {
        return participantRepo.getByCompetitionAndUserId(userId, comId);
    }

    @Override
    public List<ParticipantModel> findByCompetitionId(Long id) {
        return participantRepo.getByCompetitionId(id);
    }

    @Override
    public List<ParticipantModel> findByUserId(Long id) {
        return participantRepo.getByUserId(id);
    }

    @Override
    public ParticipantShortModel create(ParticipantShortModel model) {
        Participant root = new Participant();
        return getParticipantModel(model, root);
    }

    @Override
    public ParticipantShortModel update(Long id, ParticipantShortModel model) {
        Participant root = participantRepo.getOne(id);
        return getParticipantModel(model, root);
    }

    private ParticipantShortModel getParticipantModel(ParticipantShortModel model, Participant root) {
        root.setCompetition(competitionService.getById(model.getCompetitionId()));
        root.setUser(userService.getCurrentUserId());
        root.setStart_date(model.getStartDate());
        root.setEnd_date(model.getEndDate());
        root = participantRepo.save(root);
        model.setId(root.getId());
        return model;
    }

    @Override
    public void delete(Long id) {
        participantRepo.deleteById(id);
    }
}
