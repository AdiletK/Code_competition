package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailCheckResponse {
    private String taskDescription;
    private String participantAnswer;
    private String correctAnswer;
}
