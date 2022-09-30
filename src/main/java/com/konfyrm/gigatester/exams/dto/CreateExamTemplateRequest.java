package com.konfyrm.gigatester.exams.dto;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateExamTemplateRequest {

    /**
     * The name of the exam, for instance: "test 1"
     */
    private String name;

    /**
     * Number of closed questions
     */
    private int closedQuestionsCount;

    /**
     * Number of multiple-choice questions
     */
    private int multipleChoiceQuestionsCount;

    /**
     * Number of open questions
     */
    private int openQuestionsCount;

    public static ExamTemplate dtoToEntity(CreateExamTemplateRequest request){
        return ExamTemplate.builder()
                .uuid(UUID.randomUUID())
                .name(request.name)
                .openQuestionsCount(request.openQuestionsCount)
                .closedQuestionsCount(request.closedQuestionsCount)
                .multipleChoiceQuestionsCount(request.multipleChoiceQuestionsCount)
                .build();
    }

}
