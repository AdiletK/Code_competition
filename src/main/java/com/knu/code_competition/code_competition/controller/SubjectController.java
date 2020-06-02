package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.entity.Subject;
import com.knu.code_competition.code_competition.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/subject")
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

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public Subject create(@RequestBody Subject subject){
        return subjectService.create(subject);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{id}")
    public Subject update(@PathVariable Long id, @RequestBody Subject subject){
        return subjectService.update(id, subject);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        subjectService.delete(id);
        return ResponseEntity.ok().build();
    }
}
