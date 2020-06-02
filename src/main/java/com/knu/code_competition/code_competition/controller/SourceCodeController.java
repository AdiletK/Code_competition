package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.SourceCodeModel;
import com.knu.code_competition.code_competition.model.SourceCodeShortModel;
import com.knu.code_competition.code_competition.service.SourceCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/code")
@RestController
public class SourceCodeController {
    private final SourceCodeService sourceCode;

    public SourceCodeController(SourceCodeService sourceCode) {
        this.sourceCode = sourceCode;
    }

    @GetMapping("/all")
    public List<SourceCodeModel> findAll(){
        return sourceCode.findAll();
    }

    @GetMapping("/{id}")
    public SourceCodeModel findById(@PathVariable Long id){
        return sourceCode.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public SourceCodeShortModel create(@RequestBody SourceCodeShortModel model) {
        return sourceCode.create(model);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{id}")
    public SourceCodeShortModel update(@PathVariable Long id, @RequestBody SourceCodeShortModel model){
        return sourceCode.update(id, model);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        sourceCode.delete(id);
        return ResponseEntity.ok().build();
    }
}
