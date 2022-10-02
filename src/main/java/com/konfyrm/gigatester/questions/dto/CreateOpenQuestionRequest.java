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
                .label(request.label)
                .content(request.content)
                .sampleAnswer(request.sampleAnswer)
                .build();
    }

}
