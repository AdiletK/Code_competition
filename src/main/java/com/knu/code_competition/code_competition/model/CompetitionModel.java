package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
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

    public CompetitionModel(Long id, String name, Long subjectId, String subjectName, Long userId, String userName, String userSurname, Date start_date, Date end_date) {
        this.id = id;
        this.name = name;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
