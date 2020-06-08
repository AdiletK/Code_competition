package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.ParticipantAnswerModel;
import com.knu.code_competition.code_competition.model.ParticipantAnswerShortModel;
import com.knu.code_competition.code_competition.service.ParticipantAnswerService;
import com.knu.code_competition.code_competition.service.ParticipantAnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/participant_answer")
@RestController
public class ParticipantAnswerController {
    private final ParticipantAnswerService participantAnswerService;

    public ParticipantAnswerController(ParticipantAnswerService participantAnswerService) {
        this.participantAnswerService = participantAnswerService;
    }

    @GetMapping("/all")
    public List<ParticipantAnswerModel> findAll(){
        return participantAnswerService.findAll();
    }

    @GetMapping("/by_task/{taskId}")
    public List<ParticipantAnswerModel> findByTaskId(@PathVariable Long taskId){
        return participantAnswerService.getByTaskId(taskId);
    }

    @GetMapping("/by_participant/{parId}")
    public List<ParticipantAnswerModel> findByParticipantId(@PathVariable Long parId){
        return participantAnswerService.getByParticipantId(parId);
    }

    @GetMapping("/{id}")
    public ParticipantAnswerModel findById(@PathVariable Long id){
        return participantAnswerService.findById(id);
    }

    @PostMapping
    public ParticipantAnswerShortModel create(@RequestBody ParticipantAnswerShortModel model) {
        return participantAnswerService.create(model);
    }

    @PostMapping("/{id}")
    public ParticipantAnswerShortModel update(@PathVariable Long id, @RequestBody ParticipantAnswerShortModel model){
        return participantAnswerService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        participantAnswerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
