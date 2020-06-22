package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String username;
    private String password;
    private String role;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModel(Long id, String name, String surname, String patronymic, String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.username = username;
        this.password = password;
    }
}
