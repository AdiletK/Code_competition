package com.knu.code_competition.code_competition.controller;

import com.knu.code_competition.code_competition.entity.User;
import com.knu.code_competition.code_competition.model.UserModel;
import com.knu.code_competition.code_competition.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserModel> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserModel findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody UserModel userModel){
        return userService.update(id, userModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
