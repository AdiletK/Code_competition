package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Participant;
import com.knu.code_competition.code_competition.model.ParticipantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepo extends JpaRepository<Participant, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.ParticipantModel(p.id, p.user.id, p.user.name, p.user.surname, p.user.login, p.competition.id, p.competition.name, p.start_date, p.end_date) " +
            "from Participant p")
    List<ParticipantModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantModel(p.id, p.user.id, p.user.name, p.user.surname, p.user.login, p.competition.id, p.competition.name, p.start_date, p.end_date) " +
            "from Participant p where p.id = ?1")
    ParticipantModel getById(Long id);
}
