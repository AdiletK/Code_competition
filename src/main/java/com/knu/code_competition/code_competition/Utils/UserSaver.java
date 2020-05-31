package com.knu.code_competition.code_competition.Utils;

import com.knu.code_competition.code_competition.entity.User;
import com.knu.code_competition.code_competition.model.UserModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserSaver {
    public static User saveUser(User user,UserModel userModel){
        user.setName(userModel.getName());
        user.setSurname(userModel.getSurname());
        user.setPatronymic(userModel.getPatronymic());
        user.setLogin(userModel.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        return user;
    }

}
