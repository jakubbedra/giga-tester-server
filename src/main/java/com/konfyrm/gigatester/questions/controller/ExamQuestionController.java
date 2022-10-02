package com.konfyrm.gigatester.questions.controller;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.exams.service.ExamTemplateService;
import com.konfyrm.gigatester.questions.dto.CreateQuestionsRequest;
import com.konfyrm.gigatester.questions.dto.GetQuestionsResponse;
import com.konfyrm.gigatester.questions.entity.ClosedQuestion;
import com.konfyrm.gigatester.questions.entity.MultipleChoiceQuestion;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import com.konfyrm.gigatester.questions.service.ClosedQuestionService;
import com.konfyrm.gigatester.questions.service.MultipleChoiceQuestionService;
import com.konfyrm.gigatester.questions.service.OpenQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/exams/{examId}/questions")
@RestController
public class ExamQuestionController {

    private final ExamTemplateService examTemplateService;
    private final OpenQuestionService openQuestionService;
    private final ClosedQuestionService closedQuestionService;
    private final MultipleChoiceQuestionService multipleChoiceQuestionService;

    @Autowired
    public ExamQuestionController(
            ExamTemplateService examTemplateService,
            OpenQuestionService openQuestionService,
            ClosedQuestionService closedQuestionService,
            MultipleChoiceQuestionService multipleChoiceQuestionService
    ) {
        this.examTemplateService = examTemplateService;
        this.openQuestionService = openQuestionService;
        this.closedQuestionService = closedQuestionService;
        this.multipleChoiceQuestionService = multipleChoiceQuestionService;
    }

    @GetMapping
    public ResponseEntity<GetQuestionsResponse> getExamQuestions(
            @PathVariable("examId") Long examId,
            @PathParam("allQuestions") Boolean allQuestions
    ) {
        Optional<ExamTemplate> examTemplate = examTemplateService.findExamTemplate(examId);
        if (examTemplate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<OpenQuestion> openQuestions = allQuestions ?
                openQuestionService.findRandomQuestions(examTemplate.get()) :
                openQuestionService.findRandomQuestions(examTemplate.get(), examTemplate.get().getOpenQuestionsCount());
        List<ClosedQuestion> closedQuestions = allQuestions ?
                closedQuestionService.findRandomQuestions(examTemplate.get()) :
                closedQuestionService.findRandomQuestions(examTemplate.get(), examTemplate.get().getClosedQuestionsCount());
        List<MultipleChoiceQuestion> multipleChoiceQuestions = allQuestions ?
                multipleChoiceQuestionService.findRandomQuestions(examTemplate.get()) :
                multipleChoiceQuestionService.findRandomQuestions(examTemplate.get(), examTemplate.get().getMultipleChoiceQuestionsCount());
        GetQuestionsResponse getQuestionsResponse =
                GetQuestionsResponse.entityToDto(openQuestions, closedQuestions, multipleChoiceQuestions);
        return ResponseEntity.ok(getQuestionsResponse);
    }

    @PostMapping
    public ResponseEntity<Void> createTasks(
            @PathVariable("examId") Long examId,
            @RequestBody CreateQuestionsRequest request
    ) {
        Optional<ExamTemplate> examTemplate = examTemplateService.findExamTemplate(examId);
        if (examTemplate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<OpenQuestion> openQuestions = CreateQuestionsRequest.dtoToEntityOpenQuestions(request);
        List<ClosedQuestion> closedQuestions = CreateQuestionsRequest.dtoToEntityClosedQuestions(request);
        List<MultipleChoiceQuestion> multipleChoiceQuestions = CreateQuestionsRequest.dtoToEntityMultipleChoiceQuestions(request);

        openQuestions.forEach(q -> q.setExamTemplate(examTemplate.get()));
        closedQuestions.forEach(q -> q.setExamTemplate(examTemplate.get()));
        multipleChoiceQuestions.forEach(q -> q.setExamTemplate(examTemplate.get()));

        openQuestions.forEach(openQuestionService::saveQuestion);
        closedQuestions.forEach(closedQuestionService::saveQuestion);
        multipleChoiceQuestions.forEach(multipleChoiceQuestionService::saveQuestion);
        return ResponseEntity.ok().build();
    }

}
