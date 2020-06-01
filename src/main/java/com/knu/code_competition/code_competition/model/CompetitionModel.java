package com.knu.code_competition.code_competition.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class CompetitionModel {
    private Long id;

    private String name;

    private Long subjectId;
    private String subjectName;

    private Long userId;
    private String userName;
    private String userSurname;

    private Date start_date;

    private Date end_date;

}
