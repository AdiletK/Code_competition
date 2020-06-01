package com.knu.code_competition.code_competition.entity;

import com.knu.code_competition.code_competition.Utils.UserSaver;
import com.knu.code_competition.code_competition.enums.TaskType;
import com.knu.code_competition.code_competition.model.UserModel;
import com.knu.code_competition.code_competition.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final SubjectRepo subjectRepo;
    private final CompetitionRepo competitionRepo;
    private final TaskRepo taskRepo;
    private final AnswerRepo answerRepo;

    public DataInitializer(RoleRepo roleRepo, UserRepo userRepo, SubjectRepo subjectRepo, CompetitionRepo competitionRepo, TaskRepo taskRepo, AnswerRepo answerRepo) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.subjectRepo = subjectRepo;
        this.competitionRepo = competitionRepo;
        this.taskRepo = taskRepo;
        this.answerRepo = answerRepo;
    }

    @Override
    public void run(String... args) {
        log.debug("initializing data...");
        Arrays.asList("admin", "user").forEach(v -> this.roleRepo.saveAndFlush(Role.builder().name(v).build()));

        Arrays.asList(new UserModel(1L,"Admin","Admin","","Admin","1234","admin"),
                new UserModel(2L,"User","User","","User","123","admin"))
                .forEach(userModel -> this.userRepo.saveAndFlush(UserSaver.saveUser(new User(), userModel)));

        Arrays.asList(new Subject(1L,"IT"), new Subject(2L, "Math")).forEach(this.subjectRepo::saveAndFlush);


        Date date = new Date();
        Arrays.asList(
            new Competition(1L,"Olymp",subjectRepo.getOne(1L),userRepo.getOne(1L), date, date),
            new Competition(2L,"National Olymp",subjectRepo.getOne(2L),userRepo.getOne(1L), date, date)
        ).forEach(this.competitionRepo::saveAndFlush);

        Arrays.asList(
            new Task(1L, "First programming language?", TaskType.ANSWERS,competitionRepo.getOne(1L)),
            new Task(2L, "Second programming language?", TaskType.ANSWER,competitionRepo.getOne(2L)),
            new Task(3L, "Build 'Hello world' program in Java?", TaskType.CODE,competitionRepo.getOne(2L))
        ).forEach(this.taskRepo::saveAndFlush);

        Arrays.asList(
            new Answer(1L,"Dart", taskRepo.getOne(1L),false),
            new Answer(2L,"Java", taskRepo.getOne(1L), false),
            new Answer(3L,"C", taskRepo.getOne(1L),true),
            new Answer(4L,"JavaScript", taskRepo.getOne(1L), false),
            new Answer(5L,"Java", taskRepo.getOne(2L),true),
            new Answer(6L,"Hello world", taskRepo.getOne(3L),true)
        ).forEach(this.answerRepo::saveAndFlush);
    }
}
