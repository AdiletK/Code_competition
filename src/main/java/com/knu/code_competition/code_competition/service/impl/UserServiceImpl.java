package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.Utils.RecordNotFoundException;
import com.knu.code_competition.code_competition.Utils.UserSaver;
import com.knu.code_competition.code_competition.entity.User;
import com.knu.code_competition.code_competition.model.UserModel;
import com.knu.code_competition.code_competition.repository.UserRepo;
import com.knu.code_competition.code_competition.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserModel> findAll() {
        return userRepo.getAll();
    }

    @Override
    public UserModel findById(Long id) {
        return userRepo.findUserById(id);
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow(()-> new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public User update(Long id, UserModel userModel) {
        User updateUser = userRepo.getOne(id);
        return UserSaver.saveUser(updateUser, userModel);
    }

    @Override
    public User getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String login = null;
        if (authentication != null)
            if (authentication.getPrincipal() instanceof UserDetails)
                login = ((UserDetails) authentication.getPrincipal()).getUsername();
            else if (authentication.getPrincipal() instanceof String)
                login = (String) authentication.getPrincipal();

        System.out.println("test----------" + login + "  " + userRepo.findByLogin(login).getId());
        return userRepo.findByLogin(login);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
