package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Test;
import com.knu.code_competition.code_competition.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRepo extends JpaRepository<Test, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.TestModel(a.id, a.input, a.output, a.sourceCode.id) " +
            "from Test a")
    List<TestModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.TestModel(a.id, a.input, a.output, a.sourceCode.id) " +
            "from Test a where a.id = ?1")
    TestModel getById(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.TestModel(a.id, a.input, a.output) " +
            "from Test a where a.sourceCode.id = ?1")
    List<TestModel> getAllBySourceCodeId(Long id);
}
