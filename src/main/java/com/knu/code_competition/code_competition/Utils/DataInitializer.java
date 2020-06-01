package com.knu.code_competition.code_competition.Utils;

import com.knu.code_competition.code_competition.entity.Role;
import com.knu.code_competition.code_competition.repository.RoleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final RoleRepo roleRepo;

    public DataInitializer(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("initializing role data...");
        Arrays.asList("admin", "user").forEach(v -> this.roleRepo.saveAndFlush(Role.builder().name(v).build()));        log.debug("printing all vehicles...");
        this.roleRepo.findAll().forEach(v -> log.debug(" Role :" + v.toString()));
    }
}
