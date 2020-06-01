package com.knu.code_competition.code_competition.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ParticipantShortModel {
    private Long id;

    private Long userId;

    private Long competitionId;

    private Date startDate;

    private Date endDate;
}
