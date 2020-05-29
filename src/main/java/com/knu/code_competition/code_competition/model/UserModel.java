package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserModel {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
