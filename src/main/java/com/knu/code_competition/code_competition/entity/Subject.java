package com.knu.code_competition.code_competition.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @SequenceGenerator(name = "subject_seq", sequenceName = "subject_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "subject_seq")
    private Long id;

    @Column(name="name", length=50, nullable=false)
    private String name;
}
