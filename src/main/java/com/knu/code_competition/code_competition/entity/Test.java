package com.knu.code_competition.code_competition.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test")
public class Test {
    @Id
    @SequenceGenerator(name = "test_seq", sequenceName = "test_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
    private Long id;

    @Column(name = "input")
    private String input;

    @Column(name = "output")
    private String output;

    @ManyToOne
    @JoinColumn(name = "source_code_id")
    private SourceCode sourceCode;

}
