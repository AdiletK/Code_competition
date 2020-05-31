package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.Utils.RecordNotFoundException;
import com.knu.code_competition.code_competition.entity.Subject;
import com.knu.code_competition.code_competition.repository.SubjectRepo;
import com.knu.code_competition.code_competition.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepo subjectRepo;

    public SubjectServiceImpl(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepo.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public Subject create(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public Subject update(Long id, Subject subject) {
        Subject subjectToUpdate = subjectRepo.getOne(id);
        subjectToUpdate.setName(subject.getName());
        return subjectRepo.save(subjectToUpdate);
    }

    @Override
    public void delete(Long id) {
        subjectRepo.deleteById(id);
    }
}
