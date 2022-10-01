package com.konfyrm.gigatester.questions.controller;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.exams.service.ExamTemplateService;
import com.konfyrm.gigatester.questions.dto.CreateOpenQuestionRequest;
import com.konfyrm.gigatester.questions.dto.GetOpenQuestionsResponse;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import com.konfyrm.gigatester.questions.service.OpenQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/exams/{examId}/openQuestions")
@RestController
public class ExamOpenQuestionController {

    private final OpenQuestionService openQuestionService;
    private final ExamTemplateService examTemplateService;

    @Autowired
    public ExamOpenQuestionController(
            OpenQuestionService openQuestionService,
            ExamTemplateService examTemplateService
    ) {
        this.openQuestionService = openQuestionService;
        this.examTemplateService = examTemplateService;
    }

    @PostMapping
    public ResponseEntity<Void> createOpenQuestion(
            @PathVariable("examId") Long examId,
            @RequestBody CreateOpenQuestionRequest request
    ) {
        Optional<ExamTemplate> examTemplate = examTemplateService.findExamTemplate(examId);
        if (examTemplate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        OpenQuestion openQuestion = CreateOpenQuestionRequest.dtoToEntity(request);
        openQuestion.setExamTemplate(examTemplate.get());
        openQuestionService.saveQuestion(openQuestion);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<GetOpenQuestionsResponse> getAllOpenQuestions(@PathVariable("examId") Long examId) {
        Optional<ExamTemplate> examTemplate = examTemplateService.findExamTemplate(examId);
        if (examTemplate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<OpenQuestion> allQuestions = openQuestionService.findAllQuestions(examTemplate.get());
        GetOpenQuestionsResponse getOpenQuestionsResponse = GetOpenQuestionsResponse.entityToDto(allQuestions);
        return ResponseEntity.ok(getOpenQuestionsResponse);
    }

    @GetMapping("/random")
    public ResponseEntity<GetOpenQuestionsResponse> getRandomizedOpenQuestions(
            @PathVariable("examId") Long examId,
            @PathParam("count") Optional<Integer> count
    ) {
        Optional<ExamTemplate> examTemplate = examTemplateService.findExamTemplate(examId);
        if (examTemplate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<OpenQuestion> allQuestions = count.isPresent() ?
                openQuestionService.findRandomQuestions(examTemplate.get(), count.get()) :
                openQuestionService.findRandomQuestions(examTemplate.get());
        GetOpenQuestionsResponse getOpenQuestionsResponse = GetOpenQuestionsResponse.entityToDto(allQuestions);
        return ResponseEntity.ok(getOpenQuestionsResponse);
    }

}
