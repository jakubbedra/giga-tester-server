package com.konfyrm.gigatester.questions.dto;

import com.konfyrm.gigatester.questions.QuestionLabel;
import com.konfyrm.gigatester.questions.entity.MultipleChoiceQuestion;
import lombok.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GetMultipleChoiceQuestionResponse {

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
     * The indices of the correct answers in answers list
     */
    private List<Integer> correctAnswerIndices;

    public static GetMultipleChoiceQuestionResponse entityToDto(MultipleChoiceQuestion entity) {
        String[] split = entity.getAnswers().split("\\[2137\\]");
        List<Integer> indices = Arrays.stream(entity.getCorrectAnswerIndices().split(";"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return GetMultipleChoiceQuestionResponse.builder()
                .label(entity.getLabel())
                .content(entity.getContent())
                .answers(Arrays.asList(split))
                .correctAnswerIndices(indices)
                .build();
    }

}
