package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.CompetitionModel;
import com.knu.code_competition.code_competition.service.CompetitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/competition")
@CrossOrigin
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

    @PostMapping
    public CompetitionModel create(@RequestBody CompetitionModel model) {
        return competitionService.create(model);
    }

    @PostMapping("/{id}")
    public CompetitionModel update(@PathVariable Long id, @RequestBody CompetitionModel model){
        return competitionService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        competitionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
