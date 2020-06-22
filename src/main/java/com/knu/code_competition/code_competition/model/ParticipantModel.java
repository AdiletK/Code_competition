package com.knu.code_competition.code_competition.model;


import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ParticipantModel implements Serializable {
    private Long id;

    private Long userId;
    private String userName;
    private String userSurname;
    private String userLogin;

    private Long competitionId;
    private String competitionName;


    private Float score;
}
