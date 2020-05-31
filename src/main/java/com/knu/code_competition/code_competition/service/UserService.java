package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.User;
import com.knu.code_competition.code_competition.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> findAll();

    UserModel findById(Long id);

    User getById(Long id);

    User update(Long id, UserModel userModel);

    void delete(Long id);

    User getCurrentUserId();
}
