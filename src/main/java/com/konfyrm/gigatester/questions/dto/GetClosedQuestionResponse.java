package com.konfyrm.gigatester.questions.dto;

import com.konfyrm.gigatester.questions.QuestionLabel;
import com.konfyrm.gigatester.questions.entity.ClosedQuestion;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GetClosedQuestionResponse {

    /**
     * Tells where the question came from
     */
    private QuestionLabel label;

    /**
     * The content of the question
     */
    private String content;

    /**
     * Presented answers to the question
     */
    private List<String> answers;

    /**
     * The index of the correct answer in answers list
     */
    private int correctAnswerIndex;

    public static GetClosedQuestionResponse entityToDto(ClosedQuestion entity) {
        String[] split = entity.getAnswers().split("\\[2137\\]");
        return GetClosedQuestionResponse.builder()
                .label(entity.getLabel())
                .content(entity.getContent())
                .answers(Arrays.asList(split))
                .correctAnswerIndex(entity.getCorrectAnswerIndex())
                .build();
    }

}
