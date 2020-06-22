package com.knu.code_competition.code_competition.repository;

import com.knu.code_competition.code_competition.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
