package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.User;
import com.knu.code_competition.code_competition.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);

    @Query("select new com.knu.code_competition.code_competition.model.UserModel(user.id, user.name, user.surname, user.patronymic,user.login, user.password) " +
            "from User user")
    List<UserModel> getAll();

    @Query("select new com.knu.code_competition.code_competition.model.UserModel(user.id, user.name, user.surname, user.patronymic,user.login, user.password) " +
            "from User user where user.id =:id")
    UserModel findUserById(Long id);

    @Query("select new com.knu.code_competition.code_competition.model.UserModel(user.login, user.password) " +
            "from User user where user.login =:user")
    UserModel findUserByUserName(String user);
}
