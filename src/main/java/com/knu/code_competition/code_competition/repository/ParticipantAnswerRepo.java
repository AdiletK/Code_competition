package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.ParticipantAnswer;
import com.knu.code_competition.code_competition.model.ParticipantAnswerModel;
import com.knu.code_competition.code_competition.model.ParticipantAnswerShortModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantAnswerRepo extends JpaRepository<ParticipantAnswer, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.ParticipantAnswerModel(p.id, p.participant.user.id, p.participant.user.name, p.participant.user.surname, p.participant.user.login, p.task.id, p.task.description, p.option) " +
            "from ParticipantAnswer p")
    List<ParticipantAnswerModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantAnswerModel(p.id, p.participant.user.id, p.participant.user.name, p.participant.user.surname, p.participant.user.login, p.task.id, p.task.description, p.option) " +
            "from ParticipantAnswer p where p.id =?1")
    ParticipantAnswerModel getById(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantAnswerModel(p.id, p.participant.user.id, p.participant.user.name, p.participant.user.surname, p.participant.user.login, p.task.id, p.task.description, p.option) " +
            "from ParticipantAnswer p where p.participant.id =?1")
    List<ParticipantAnswerModel> getByParticipantId(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantAnswerShortModel(p.id, p.task.id, p.isCorrect, p.option) " +
            "from ParticipantAnswer p where p.participant.id =?1")
    List<ParticipantAnswerShortModel> getShortByParticipantId(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.ParticipantAnswerModel(p.id, p.participant.user.id, p.participant.user.name, p.participant.user.surname, p.participant.user.login, p.task.id, p.task.description, p.option) " +
            "from ParticipantAnswer p where p.task.id =?1")
    List<ParticipantAnswerModel> getByTaskId(Long id);
}
