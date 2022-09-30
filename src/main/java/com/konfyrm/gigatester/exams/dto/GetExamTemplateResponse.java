package com.konfyrm.gigatester.exams.dto;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import lombok.*;

import javax.persistence.Id;
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
    @Id
    private UUID uuid;

    /**
     * Uuid of the subject that the exam template is from
     */
    private UUID subjectUuid;

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
                .uuid(entity.getUuid())
                .subjectUuid(entity.getSubject().getUuid())
                .openQuestionsCount(entity.getOpenQuestionsCount())
                .closedQuestionsCount(entity.getClosedQuestionsCount())
                .multipleChoiceQuestionsCount(entity.getMultipleChoiceQuestionsCount())
                .name(entity.getName())
                .build();
    }

}
