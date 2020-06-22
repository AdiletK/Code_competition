package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.model.TestModel;
import com.knu.code_competition.code_competition.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/test")
@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/all")
    public List<TestModel> findAll(){
        return testService.findAll();
    }

    @GetMapping("/by_code/{id}")
    public List<TestModel> findAllByCodeId(@PathVariable Long id){
        return testService.findAllBySourceCodeId(id);
    }

    @GetMapping("/{id}")
    public TestModel findById(@PathVariable Long id){
        return testService.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping
    public TestModel create(@RequestBody TestModel model) {
        return testService.create(model);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/{id}")
    public TestModel update(@PathVariable Long id, @RequestBody TestModel model){
        return testService.update(id, model);
    }

    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        testService.delete(id);
        return ResponseEntity.ok().build();
    }
}
