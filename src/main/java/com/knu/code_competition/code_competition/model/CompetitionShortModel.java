package com.knu.code_competition.code_competition.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class CompetitionShortModel {
    private Long id;

    private String name;

    private Long subjectId;

    private Date start_date;

    private Date end_date;

    public CompetitionShortModel(Long id, String name, Long subjectId, Date start_date, Date end_date) {
        this.id = id;
        this.name = name;
        this.subjectId = subjectId;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
