package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.OptionModel;
import com.knu.code_competition.code_competition.model.OptionShortModel;
import com.knu.code_competition.code_competition.service.OptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/option")
@RestController
public class OptionController {
    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/all")
    public List<OptionModel> findAll(){
        return optionService.findAll();
    }

    @GetMapping("/{id}")
    public OptionModel findById(@PathVariable Long id){
        return optionService.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public OptionShortModel create(@RequestBody OptionShortModel model) {
        return optionService.create(model);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{id}")
    public OptionShortModel update(@PathVariable Long id, @RequestBody OptionShortModel model){
        return optionService.update(id, model);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        optionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
