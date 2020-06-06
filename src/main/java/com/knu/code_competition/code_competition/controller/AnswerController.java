package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.AnswerModel;
import com.knu.code_competition.code_competition.model.AnswerShortModel;
import com.knu.code_competition.code_competition.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('admin')")
@CrossOrigin
@RequestMapping("/api/v1/answer")
@RestController
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/all")
    public List<AnswerModel> findAll(){
        return answerService.findAll();
    }

    @GetMapping("/{id}")
    public AnswerModel findById(@PathVariable Long id){
        return answerService.findById(id);
    }

    @GetMapping("/by_task/{id}")
    public AnswerModel findByTaskId(@PathVariable Long id){
        return answerService.findByTaskId(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public AnswerShortModel create(@RequestBody AnswerShortModel model) {
        return answerService.create(model);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{id}")
    public AnswerShortModel update(@PathVariable Long id, @RequestBody AnswerShortModel model){
        return answerService.update(id, model);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        answerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
