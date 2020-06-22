package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.enums.TaskType;
import com.knu.code_competition.code_competition.model.ResponseCheckModel;
import com.knu.code_competition.code_competition.model.TaskModel;
import com.knu.code_competition.code_competition.model.TaskShortModel;
import com.knu.code_competition.code_competition.service.CheckTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RequestMapping("/api/v1/check")
@RestController
public class TaskCheckerController {
    private final CheckTaskService checkTaskService;

    public TaskCheckerController(CheckTaskService checkTaskService) {
        this.checkTaskService = checkTaskService;
    }
//
//    @GetMapping("/all")
//    public List<ResponseCheckModel> findAll(){
////        return checkTaskService.();
//        return null;
//    }
    @GetMapping("/by_competition/{id}")
    public List<ResponseCheckModel> findAllCompetitionId(@PathVariable Long id){
        return checkTaskService.checkByCompetitionId(id);
    }
    @GetMapping("/by_user/{id}")
    public List<ResponseCheckModel> findAllUserId(@PathVariable Long id){
        return checkTaskService.checkByUserId(id);
    }
    @GetMapping("/by_user_and_comp/{userId}/{compId}")
    public List<ResponseCheckModel> findAllUserAndCompId(@PathVariable Long compId,
                                                         @PathVariable Long userId){
        return checkTaskService.checkByUserAndCompetitionId(compId, userId);
    }
//    @GetMapping("/by_/{id}")
//    public List<TaskModel> findAllCompetitionId(@PathVariable Long id){
//        return checkTaskService.findAllByCompetitionId(id);
//    }


}
