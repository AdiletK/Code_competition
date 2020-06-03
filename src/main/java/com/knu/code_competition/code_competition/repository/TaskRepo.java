package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Task;
import com.knu.code_competition.code_competition.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.TaskModel(t.id, t.description, t.taskType, t.competition.id, t.competition.name) " +
            "from Task t")
    List<TaskModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.TaskModel(t.id, t.description, t.taskType, t.competition.id, t.competition.name) " +
            "from Task t where t.id = ?1")
    TaskModel findTaskById(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.TaskModel(t.id, t.description, t.taskType, t.competition.id, t.competition.name) " +
            "from Task t where t.competition.id=?1")
    List<TaskModel> getAllByTaskId(Long taskId);
}
