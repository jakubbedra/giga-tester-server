package com.konfyrm.gigatester.questions.dto;

import com.konfyrm.gigatester.questions.QuestionLabel;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateOpenQuestionRequest {

    /**
     * The uuid of the exam template to which this question belongs to
     */
    private UUID examTemplateUuid;

    /**
     * Tells where the question came from
     */
    private QuestionLabel label;

    /**
     * The content of the question
     */
    private String content;

    /**
     * Example answer to the question
     */
    private String sampleAnswer;

    public static OpenQuestion dtoToEntity(CreateOpenQuestionRequest request) {
        return OpenQuestion.builder()
                .uuid(UUID.randomUUID())
                .label(request.label)
                .content(request.content)
                .sampleAnswer(request.sampleAnswer)
                .build();
    }

}
