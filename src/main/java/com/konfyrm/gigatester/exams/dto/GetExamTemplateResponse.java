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
public class GetExamTemplateResponse {

    /**
     * The unique identifier of the template
     */
    private Long id;

    /**
     * Uuid of the subject that the exam template is from
     */
    private Long subjectId;

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

    public static GetExamTemplateResponse entityToDto(ExamTemplate entity) {
        return GetExamTemplateResponse.builder()
                .id(entity.getId())
                .subjectId(entity.getSubject().getId())
                .openQuestionsCount(entity.getOpenQuestionsCount())
                .closedQuestionsCount(entity.getClosedQuestionsCount())
                .multipleChoiceQuestionsCount(entity.getMultipleChoiceQuestionsCount())
                .name(entity.getName())
                .build();
    }

}
