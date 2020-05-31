package com.knu.code_competition.code_competition.service;

import com.knu.code_competition.code_competition.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

    Subject findById(Long id);

    Subject create(Subject subject);

    Subject update(Long id, Subject subject);

    void delete(Long id);
}
