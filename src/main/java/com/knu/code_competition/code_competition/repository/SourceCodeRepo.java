package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.SourceCode;
import com.knu.code_competition.code_competition.model.SourceCodeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SourceCodeRepo extends JpaRepository<SourceCode, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.SourceCodeModel(a.id, a.time, a.memory, a.task.id, a.task.description) " +
            "from SourceCode a")
    List<SourceCodeModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.SourceCodeModel(a.id, a.time, a.memory, a.task.id, a.task.description) " +
            "from SourceCode a where a.id =?1")
    SourceCodeModel getById(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.SourceCodeModel(a.id, a.time, a.memory, a.task.id, a.task.description) " +
            "from SourceCode a where a.task.id =?1")
    SourceCodeModel getByTaskId(Long id);

}
