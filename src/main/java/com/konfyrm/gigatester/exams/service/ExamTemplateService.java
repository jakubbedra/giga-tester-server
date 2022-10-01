package com.konfyrm.gigatester.exams.service;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.exams.entity.Subject;
import com.konfyrm.gigatester.exams.repository.ExamTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamTemplateService {

    private final ExamTemplateRepository examTemplateRepository;

    @Autowired
    public ExamTemplateService(
            ExamTemplateRepository examTemplateRepository
    ) {
        this.examTemplateRepository = examTemplateRepository;
    }

    public void saveExamTemplate(ExamTemplate examTemplate) {
        examTemplateRepository.save(examTemplate);
    }

    public List<ExamTemplate> findAllExamTemplates() {
        return (List<ExamTemplate>) examTemplateRepository.findAll();
    }

    public List<ExamTemplate> findAllExamTemplatesBySubject(Subject subject) {
        return (List<ExamTemplate>) examTemplateRepository.findAllBySubject(subject);
    }

    public Optional<ExamTemplate> findExamTemplate(Long id) {
        return examTemplateRepository.findById(id);
    }

}
