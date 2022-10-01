package com.konfyrm.gigatester.exams.controller;

import com.konfyrm.gigatester.exams.dto.CreateExamTemplateRequest;
import com.konfyrm.gigatester.exams.dto.GetExamTemplateResponse;
import com.konfyrm.gigatester.exams.dto.GetExamTemplatesResponse;
import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.exams.service.ExamTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/examTemplates")
@RestController
public class ExamTemplateController {

    private final ExamTemplateService examTemplateService;

    @Autowired
    public ExamTemplateController(
            ExamTemplateService examTemplateService
    ) {
        this.examTemplateService = examTemplateService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetExamTemplateResponse> getExamTemplate(@PathVariable("id") Long id) {
        Optional<ExamTemplate> examTemplate = examTemplateService.findExamTemplate(id);
        if (examTemplate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        GetExamTemplateResponse response = GetExamTemplateResponse.entityToDto(examTemplate.get());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetExamTemplatesResponse> getExamTemplates() {
        List<ExamTemplate> examTemplates = examTemplateService.findAllExamTemplates();
        GetExamTemplatesResponse response = GetExamTemplatesResponse.entityToDto(examTemplates);
        return ResponseEntity.ok(response);
    }

}
