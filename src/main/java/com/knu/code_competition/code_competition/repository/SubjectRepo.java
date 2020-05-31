package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
