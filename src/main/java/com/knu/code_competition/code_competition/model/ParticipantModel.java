package com.knu.code_competition.code_competition.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ParticipantModel implements Serializable {
    private Long id;

    private Long userId;
    private String userName;
    private String userSurname;
    private String userLogin;

    private Long competitionId;
    private String competitionName;

    private Date start_date;

    private Date end_date;

    private Float score;
}
