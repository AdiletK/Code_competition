package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompilerResponseModel {
    private String output;
    private String statusCode;
    private String memory;
    private String cpuTime;

}
