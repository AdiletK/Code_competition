package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompilerResponseModel {
    private String output;
    private String statusCode;
    private String memory;
    private String cpuTime;
    private String message;

    public CompilerResponseModel(String message) {
        this.message = message;
    }
}
