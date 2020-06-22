package com.knu.code_competition.code_competition.Utils;

import com.knu.code_competition.code_competition.entity.User;
import com.knu.code_competition.code_competition.model.UserModel;
import com.knu.code_competition.code_competition.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;

@Component
public class UserSaver {
    private static RoleRepo roleRepo;

    public UserSaver(RoleRepo roleRepo) {
        UserSaver.roleRepo = roleRepo;
    }

    public static User saveUser(User user,UserModel userModel){
        user.setName(userModel.getName());
        user.setSurname(userModel.getSurname());
        user.setPatronymic(userModel.getPatronymic());
        user.setLogin(userModel.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        user.setRoles((Collections.singleton(roleRepo.findByName(userModel.getRole()))));

        return user;
    }

}
