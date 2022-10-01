package com.konfyrm.gigatester.exams.service;

import com.konfyrm.gigatester.exams.entity.SubjectGroup;
import com.konfyrm.gigatester.exams.repository.SubjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectGroupService {

    private final SubjectGroupRepository subjectGroupRepository;

    @Autowired
    public SubjectGroupService(
            SubjectGroupRepository subjectGroupRepository
    ) {
        this.subjectGroupRepository = subjectGroupRepository;
    }

    public void saveSubjectGroup(SubjectGroup subjectGroup){
        subjectGroupRepository.save(subjectGroup);
    }

}
