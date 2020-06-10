package com.knu.code_competition.code_competition.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "competition")
public class Competition {
    @Id
    @SequenceGenerator(name = "competition_seq", sequenceName = "competition_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "competition_seq")
    private Long id;

    @Column(name="name", length=50, nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(name = "start_datetime")
    private Date start_date;

    @Column(name = "end_datetime")
    private Date end_date;

}
