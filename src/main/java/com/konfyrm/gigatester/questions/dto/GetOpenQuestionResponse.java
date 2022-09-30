package com.konfyrm.gigatester.questions.dto;

import com.konfyrm.gigatester.questions.QuestionLabel;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GetOpenQuestionResponse {

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


    public static GetOpenQuestionResponse entityToDto(OpenQuestion entity) {
        return GetOpenQuestionResponse.builder()
                .label(entity.getLabel())
                .content(entity.getContent())
                .sampleAnswer(entity.getSampleAnswer())
                .build();
    }

}
