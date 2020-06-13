package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Participant;
import com.knu.code_competition.code_competition.model.ParticipantModel;
import org.hibernate.annotations.LazyToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepo extends JpaRepository<Participant, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.ParticipantModel(p.id, p.user.id, p.user.name, p.user.surname, p.user.login, p.competition.id, p.competition.name, p.score) " +
            "from Participant p")
    List<ParticipantModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantModel(p.id, p.user.id, p.user.name, p.user.surname, p.user.login, p.competition.id, p.competition.name, p.score) " +
            "from Participant p where p.id = ?1")
    ParticipantModel getById(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantModel(p.id, p.user.id, p.user.name, p.user.surname, p.user.login, p.competition.id, p.competition.name, p.score) " +
            "from Participant p where p.user.id = ?1 and  p.competition.id = ?2 and p.competition.end_date >= current_timestamp")
    List<ParticipantModel> getActiveByCompetitionAndUserId(Long userId, Long competitionId);

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantModel(p.id, p.user.id, p.user.name, p.user.surname, p.user.login, p.competition.id, p.competition.name, p.score) " +
            "from Participant p where p.user.id = ?1 and  p.competition.id = ?2")
    List<ParticipantModel> getByCompetitionAndUserId(Long userId, Long competitionId);

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantModel(p.id, p.user.id, p.user.name, p.user.surname, p.user.login, p.competition.id, p.competition.name, p.score) " +
            "from Participant p where p.competition.id = ?1")
    List<ParticipantModel> getByCompetitionId(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantModel(p.id, p.user.id, p.user.name, p.user.surname, p.user.login, p.competition.id, p.competition.name, p.score) " +
            "from Participant p where p.user.id = ?1")
    List<ParticipantModel> getByUserId(Long id);
}
