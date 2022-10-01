package com.konfyrm.gigatester.questions.controller;


import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.exams.service.ExamTemplateService;
import com.konfyrm.gigatester.questions.dto.CreateMultipleChoiceQuestionRequest;
import com.konfyrm.gigatester.questions.entity.MultipleChoiceQuestion;
import com.konfyrm.gigatester.questions.service.MultipleChoiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/exams/{examId}/multipleChoiceQuestions")
@RestController
public class ExamMultipleChoiceQuestionController {

    private final ExamTemplateService examTemplateService;
    private final MultipleChoiceQuestionService multipleChoiceQuestionService;

    @Autowired
    public ExamMultipleChoiceQuestionController(
            ExamTemplateService examTemplateService,
            MultipleChoiceQuestionService multipleChoiceQuestionService
    ) {
        this.examTemplateService = examTemplateService;
        this.multipleChoiceQuestionService = multipleChoiceQuestionService;
    }

    @PostMapping
    public ResponseEntity<Void> createMultipleChoiceQuestion(
            @PathVariable("examId") Long examId,
            @RequestBody CreateMultipleChoiceQuestionRequest request
    ) {
        Optional<ExamTemplate> examTemplate = examTemplateService.findExamTemplate(examId);
        if (examTemplate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        MultipleChoiceQuestion multipleChoiceQuestion = CreateMultipleChoiceQuestionRequest.dtoToEntity(request);
        multipleChoiceQuestion.setExamTemplate(examTemplate.get());
        multipleChoiceQuestionService.saveQuestion(multipleChoiceQuestion);
        return ResponseEntity.ok().build();
    }

}
