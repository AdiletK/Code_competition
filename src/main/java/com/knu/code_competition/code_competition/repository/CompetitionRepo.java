package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Competition;
import com.knu.code_competition.code_competition.model.CompetitionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompetitionRepo extends JpaRepository<Competition, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.CompetitionModel(c.id, c.name, c.subject.id, c.subject.name, c.user.id, c.user.name, c.user.surname, c.start_date, c.end_date) " +
            "from Competition c")
    List<CompetitionModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.CompetitionModel(c.id, c.name, c.subject.id, c.subject.name, c.user.id, c.user.name, c.user.surname, c.start_date, c.end_date) " +
            "from Competition c where c.id =?1")
    CompetitionModel findCompetitionById(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.CompetitionModel(c.id, c.name, c.subject.id, c.subject.name, c.user.id, c.user.name, c.user.surname, c.start_date, c.end_date) " +
            "from Competition c where  c.subject.id =?1")
    List<CompetitionModel> getAllBySubjectId(Long subjectId);

    @Query("select new com.knu.code_competition.code_competition.model.CompetitionModel(c.id, c.name, c.subject.id, c.subject.name, c.user.id, c.user.name, c.user.surname, c.start_date, c.end_date) " +
            "from Competition c where c.end_date >= current_timestamp")
    List<CompetitionModel> getActiveCompetition();

    @Query("select new com.knu.code_competition.code_competition.model.CompetitionModel(c.id, c.name, c.subject.id, c.subject.name, c.user.id, c.user.name, c.user.surname, c.start_date, c.end_date) " +
            "from Competition c where c.end_date < current_timestamp")
    List<CompetitionModel> getCompletedCompetition();
}
