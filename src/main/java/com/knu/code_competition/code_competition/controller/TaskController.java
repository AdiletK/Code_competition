package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.enums.TaskType;
import com.knu.code_competition.code_competition.model.TaskModel;
import com.knu.code_competition.code_competition.model.TaskShortModel;
import com.knu.code_competition.code_competition.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RequestMapping("/api/v1/task")
@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public List<TaskModel> findAll(){
        return taskService.findAll();
    }
    @GetMapping("/by_competition/{id}")
    public List<TaskModel> findAllCompetitionId(@PathVariable Long id){
        return taskService.findAllByCompetitionId(id);
    }

    @GetMapping("/types")
    public TaskType[] taskTypes(){
        return taskService.taskTypes();
    }

    @GetMapping("/{id}")
    public TaskModel findById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public TaskShortModel create(@RequestBody TaskShortModel model) {
        return taskService.create(model);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{id}")
    public TaskShortModel update(@PathVariable Long id, @RequestBody TaskShortModel model){
        return taskService.update(id, model);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}
