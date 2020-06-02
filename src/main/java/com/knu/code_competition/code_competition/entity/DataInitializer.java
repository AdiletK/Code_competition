//package com.knu.code_competition.code_competition.entity;
//
//import com.knu.code_competition.code_competition.Utils.UserSaver;
//import com.knu.code_competition.code_competition.enums.TaskType;
//import com.knu.code_competition.code_competition.model.UserModel;
//import com.knu.code_competition.code_competition.repository.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Date;
//
//@Component
//@Slf4j
//public class DataInitializer implements CommandLineRunner {
//    private final RoleRepo roleRepo;
//    private final UserRepo userRepo;
//    private final SubjectRepo subjectRepo;
//    private final CompetitionRepo competitionRepo;
//    private final TaskRepo taskRepo;
//
//    public DataInitializer(RoleRepo roleRepo, UserRepo userRepo, SubjectRepo subjectRepo, CompetitionRepo competitionRepo, TaskRepo taskRepo) {
//        this.roleRepo = roleRepo;
//        this.userRepo = userRepo;
//        this.subjectRepo = subjectRepo;
//        this.competitionRepo = competitionRepo;
//        this.taskRepo = taskRepo;
//    }
//
//    @Override
//    public void run(String... args) {
//        log.debug("initializing data...");
//        Arrays.asList("admin", "user").forEach(v -> this.roleRepo.saveAndFlush(Role.builder().name(v).build()));
//
//        Arrays.asList(new UserModel(1L,"Admin","Admin","","admin","1234","admin"),
//                new UserModel(2L,"User","User","","user","123","user"))
//                .forEach(userModel -> this.userRepo.saveAndFlush(UserSaver.saveUser(new User(), userModel)));
//
//        Arrays.asList(new Subject(1L,"IT"), new Subject(2L, "Math")).forEach(this.subjectRepo::saveAndFlush);
//
//
//        Date date = new Date();
//        Arrays.asList(
//            new Competition(1L,"Olymp",subjectRepo.getOne(1L),userRepo.getOne(1L), date, date),
//            new Competition(2L,"National Olymp",subjectRepo.getOne(2L),userRepo.getOne(1L), date, date)
//        ).forEach(this.competitionRepo::saveAndFlush);
//
//        Arrays.asList(
//            new Task(1L, "First programming language?", TaskType.ANSWERS,competitionRepo.getOne(1L)),
//            new Task(2L, "Second programming language?", TaskType.ANSWER,competitionRepo.getOne(2L)),
//            new Task(3L, "Build 'Hello world' program in Java?", TaskType.CODE,competitionRepo.getOne(2L))
//        ).forEach(this.taskRepo::saveAndFlush);
//
//    }
//}
