package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultIsEmpty {
    Boolean isEmpty;

    public ResultIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
}
