package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.ParticipantModel;
import com.knu.code_competition.code_competition.model.ParticipantShortModel;
import com.knu.code_competition.code_competition.service.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/participant")
@RestController
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/all")
    public List<ParticipantModel> findAll(){
        return participantService.findAll();
    }

    @GetMapping("/by_user/{userId}")
    public List<ParticipantModel> findByUserId(@PathVariable Long userId){
        return participantService.findByUserId(userId);
    }

    @GetMapping("/by_competition/{comId}")
    public List<ParticipantModel> findByCompId(@PathVariable Long comId){
        return participantService.findByCompetitionId(comId);
    }
    @GetMapping("/{id}")
    public ParticipantModel findById(@PathVariable Long id){
        return participantService.findById(id);
    }

    @PostMapping
    public ParticipantShortModel create(@RequestBody ParticipantShortModel model) {
        return participantService.create(model);
    }

    @PostMapping("/{id}")
    public ParticipantShortModel update(@PathVariable Long id, @RequestBody ParticipantShortModel model){
        return participantService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        participantService.delete(id);
        return ResponseEntity.ok().build();
    }
}
