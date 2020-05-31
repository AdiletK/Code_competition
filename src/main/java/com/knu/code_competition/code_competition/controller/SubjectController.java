package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.entity.Subject;
import com.knu.code_competition.code_competition.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/subject")
@CrossOrigin
@RestController
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/all")
    public List<Subject> findAll(){
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable Long id){
        return subjectService.findById(id);
    }

    @PostMapping
    public Subject create(@RequestBody Subject subject){
        return subjectService.create(subject);
    }

    @PostMapping("/{id}")
    public Subject update(@PathVariable Long id, @RequestBody Subject subject){
        return subjectService.update(id, subject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        subjectService.delete(id);
        return ResponseEntity.ok().build();
    }
}
