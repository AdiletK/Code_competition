package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class TestModel implements Serializable {
    private Long id;

    private String input;

    private String output;

    private Long sourceCodeId;

    public TestModel(Long id, String input, String output) {
        this.id = id;
        this.input = input;
        this.output = output;
    }
}
