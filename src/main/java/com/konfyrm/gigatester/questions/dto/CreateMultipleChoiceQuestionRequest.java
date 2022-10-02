package com.konfyrm.gigatester.questions.dto;

import com.konfyrm.gigatester.questions.QuestionLabel;
import com.konfyrm.gigatester.questions.entity.MultipleChoiceQuestion;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateMultipleChoiceQuestionRequest {

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

    public static MultipleChoiceQuestion dtoToEntity(CreateMultipleChoiceQuestionRequest request) {
        StringBuilder answers = new StringBuilder();
        request.answers.forEach(answer -> answers.append(answer).append("[2137]"));
        StringBuilder correctAnswerIndices = new StringBuilder();
        request.correctAnswerIndices.forEach(ind -> correctAnswerIndices.append(ind).append(";"));
        return MultipleChoiceQuestion.builder()
                .label(request.label)
                .content(request.content)
                .answers(answers.toString())
                .correctAnswerIndices(correctAnswerIndices.toString())
                .build();
    }

}
