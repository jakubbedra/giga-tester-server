package com.konfyrm.gigatester.exams.service;

import com.konfyrm.gigatester.exams.entity.Subject;
import com.konfyrm.gigatester.exams.entity.SubjectGroup;
import com.konfyrm.gigatester.exams.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(
            SubjectRepository subjectRepository
    ) {
        this.subjectRepository = subjectRepository;
    }

    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public List<Subject> findAllSubjects() {
        return (List<Subject>) subjectRepository.findAll();
    }

    public List<Subject> findAllSubjectsByGroup(SubjectGroup subjectGroup) {
        return ((List<Subject>) subjectRepository.findAll()).stream()
                .filter(s -> s.getSubjectGroups().contains(subjectGroup))
                .collect(Collectors.toList());
    }

    public Optional<Subject> findSubject(Long id) {
        return subjectRepository.findById(id);
    }

}

