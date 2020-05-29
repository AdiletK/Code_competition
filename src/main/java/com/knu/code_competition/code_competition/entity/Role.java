package com.knu.code_competition.code_competition.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "role_seq")
    private Long id;

    @Column(name="name", length=50, nullable=false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
