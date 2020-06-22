package com.knu.code_competition.code_competition.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private final String jwttoken;
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String username;

    public JwtResponse(String jwttoken, Long id, String name, String surname, String patronymic, String username) {
        this.jwttoken = jwttoken;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.username = username;
    }

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
