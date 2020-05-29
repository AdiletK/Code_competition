package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.User;
import com.knu.code_competition.code_competition.model.UserModel;
import com.knu.code_competition.code_competition.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public User save(UserModel userModel) {
        User user = new User();
        user.setName(userModel.getName());
        user.setSurname(userModel.getSurname());
        user.setPatronymic(userModel.getPatronymic());
        user.setLogin(userModel.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        return userRepo.save(user);
    }
}
