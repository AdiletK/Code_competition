package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCheckModel {
    private String participantName;
    private Integer correctAnswersCount;
    private Integer tasksCount;
    private List<DetailCheckResponse> detailCheckResponses;
}
