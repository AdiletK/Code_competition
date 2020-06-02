package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.CompetitionModel;
import com.knu.code_competition.code_competition.model.CompetitionShortModel;
import com.knu.code_competition.code_competition.service.CompetitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/competition")
@RestController
public class CompetitionController {
    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/all")
    public List<CompetitionModel> findAll(){
        return competitionService.findAll();
    }

    @GetMapping("/{id}")
    public CompetitionModel findById(@PathVariable Long id){
        return competitionService.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public CompetitionShortModel create(@RequestBody CompetitionShortModel model) {
        return competitionService.create(model);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{id}")
    public CompetitionShortModel update(@PathVariable Long id, @RequestBody CompetitionShortModel model){
        return competitionService.update(id, model);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        competitionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
