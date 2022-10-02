package com.konfyrm.gigatester.exams.controller;

import com.konfyrm.gigatester.exams.dto.*;
import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.exams.entity.Subject;
import com.konfyrm.gigatester.exams.service.ExamTemplateService;
import com.konfyrm.gigatester.exams.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/subjects")
@RestController
public class SubjectController {

    private final SubjectService subjectService;
    private final ExamTemplateService examTemplateService;

    @Autowired
    public SubjectController(
            SubjectService subjectService,
            ExamTemplateService examTemplateService
    ) {
        this.subjectService = subjectService;
        this.examTemplateService = examTemplateService;
    }

    @PostMapping
    public ResponseEntity<Void> createSubject(CreateSubjectRequest request) {
        Subject subject = CreateSubjectRequest.dtoToEntity(request);
        subjectService.saveSubject(subject);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSubjectResponse> getSubject(@PathVariable("id") Long id) {
        Optional<Subject> subject = subjectService.findSubject(id);
        if (subject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        GetSubjectResponse response = GetSubjectResponse.entityToDto(subject.get());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetSubjectsResponse> getSubjects() {
        List<Subject> allSubjects = subjectService.findAllSubjects();
        GetSubjectsResponse response = GetSubjectsResponse.entityToDto(allSubjects);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/templates")
    public ResponseEntity<Void> createExamTemplate(
            @PathVariable("id") Long id,
            @RequestBody CreateExamTemplateRequest request
    ) {
        Optional<Subject> subject = subjectService.findSubject(id);
        if (subject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ExamTemplate examTemplate = CreateExamTemplateRequest.dtoToEntity(request);
        examTemplate.setSubject(subject.get());
        examTemplateService.saveExamTemplate(examTemplate);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/templates")
    public ResponseEntity<GetExamTemplatesResponse> getExamTemplates(
            @PathVariable("id") Long id
    ) {
        Optional<Subject> subject = subjectService.findSubject(id);
        if (subject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ExamTemplate> templates = examTemplateService.findAllExamTemplatesBySubject(subject.get());
        GetExamTemplatesResponse response = GetExamTemplatesResponse.entityToDto(templates);
        return ResponseEntity.ok(response);
    }

}
