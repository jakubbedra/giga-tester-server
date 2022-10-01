package com.konfyrm.gigatester.questions.dto;

import com.konfyrm.gigatester.questions.QuestionLabel;
import com.konfyrm.gigatester.questions.entity.ClosedQuestion;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateClosedQuestionRequest {

    /**
     * The uuid of the exam to which this question belongs
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
     * Presented answers to the question
     */
    private List<String> answers;

    /**
     * The index of the correct answer in answers list
     */
    private int correctAnswerIndex;

    public static ClosedQuestion dtoToEntity(CreateClosedQuestionRequest request) {
        StringBuilder answers = new StringBuilder();
        request.answers.forEach(answer -> answers.append(answer).append("[2137]"));
        return ClosedQuestion.builder()
                .label(request.label)
                .content(request.content)
                .answers(answers.toString())
                .correctAnswerIndex(request.correctAnswerIndex)
                .build();
    }

}
