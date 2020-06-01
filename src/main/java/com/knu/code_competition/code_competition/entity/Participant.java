package com.knu.code_competition.code_competition.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "participant")
public class Participant {
    @Id
    @SequenceGenerator(name = "participant_seq", sequenceName = "participant_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participant_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @Column(name = "score")
    private Float score;

    @Column(name = "start_datetime")
    private Date start_date;

    @Column(name = "end_datetime")
    private Date end_date;
}
