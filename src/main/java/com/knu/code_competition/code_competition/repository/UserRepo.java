package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.User;
import com.knu.code_competition.code_competition.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query("select new com.knu.code_competition.code_competition.model.UserModel(user.login, user.password) " +
            "from User user where user.login =:user")
    UserModel findUserByUserName(String user);
}
