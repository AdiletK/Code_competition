package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Option;
import com.knu.code_competition.code_competition.model.OptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OptionRepo extends JpaRepository<Option, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.OptionModel(a.id, a.option, a.task.id, a.task.description, a.isCorrect) " +
            "from Option a")
    List<OptionModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.OptionModel(a.id, a.option, a.task.id, a.task.description, a.isCorrect) " +
            "from Option a where a.id =?1")
    OptionModel getById(Long id);
}
