package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Answer;
import com.knu.code_competition.code_competition.model.AnswerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.AnswerModel(a.id, a.answer, a.task.id, a.task.description) " +
            "from Answer a")
    List<AnswerModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.AnswerModel(a.id, a.answer, a.task.id, a.task.description) " +
            "from Answer a where a.id =?1")
    AnswerModel getById(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.AnswerModel(a.id, a.answer, a.task.id, a.task.description) " +
            "from Answer a where a.task.id =?1")
    AnswerModel getByTaskId(Long taskId);

}
