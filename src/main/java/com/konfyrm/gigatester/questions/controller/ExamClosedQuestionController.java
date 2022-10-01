package com.konfyrm.gigatester.questions.controller;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.exams.service.ExamTemplateService;
import com.konfyrm.gigatester.questions.dto.CreateClosedQuestionRequest;
import com.konfyrm.gigatester.questions.entity.ClosedQuestion;
import com.konfyrm.gigatester.questions.service.ClosedQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/exams/{examId}/closedQuestions")
@RestController
public class ExamClosedQuestionController {

    private final ExamTemplateService examTemplateService;
    private final ClosedQuestionService closedQuestionService;

    @Autowired
    public ExamClosedQuestionController(
            ExamTemplateService examTemplateService,
            ClosedQuestionService closedQuestionService
    ) {
        this.examTemplateService = examTemplateService;
        this.closedQuestionService = closedQuestionService;
    }

    @PostMapping
    public ResponseEntity<Void> createClosedQuestion(
            @PathVariable("examId") Long examId,
            @RequestBody CreateClosedQuestionRequest request
    ) {
        Optional<ExamTemplate> examTemplate = examTemplateService.findExamTemplate(examId);
        if (examTemplate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ClosedQuestion closedQuestion = CreateClosedQuestionRequest.dtoToEntity(request);
        closedQuestion.setExamTemplate(examTemplate.get());
        closedQuestionService.saveQuestion(closedQuestion);
        return ResponseEntity.ok().build();
    }

}
