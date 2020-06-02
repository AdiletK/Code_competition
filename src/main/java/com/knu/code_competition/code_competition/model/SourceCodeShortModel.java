package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class SourceCodeShortModel implements Serializable {
    private Long id;

    private Float time;

    private Float memory;

    private Long taskId;
}
