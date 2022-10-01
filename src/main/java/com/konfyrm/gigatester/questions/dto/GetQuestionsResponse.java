package com.konfyrm.gigatester.questions.dto;

import com.konfyrm.gigatester.questions.entity.ClosedQuestion;
import com.konfyrm.gigatester.questions.entity.MultipleChoiceQuestion;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GetQuestionsResponse {

    private List<GetOpenQuestionResponse> openQuestionResponses;
    private List<GetClosedQuestionResponse> closedQuestionResponses;
    private List<GetMultipleChoiceQuestionResponse> multipleChoiceQuestionResponses;

    public static GetQuestionsResponse entityToDto(
            List<OpenQuestion> openQuestions,
            List<ClosedQuestion> closedQuestions,
            List<MultipleChoiceQuestion> multipleChoiceQuestions
    ){
        List<GetOpenQuestionResponse> collectOQ = openQuestions.stream()
                .map(GetOpenQuestionResponse::entityToDto)
                .collect(Collectors.toList());
        List<GetClosedQuestionResponse> collectCQ = closedQuestions.stream()
                .map(GetClosedQuestionResponse::entityToDto)
                .collect(Collectors.toList());
        List<GetMultipleChoiceQuestionResponse> collectMCQ = multipleChoiceQuestions.stream()
                .map(GetMultipleChoiceQuestionResponse::entityToDto)
                .collect(Collectors.toList());
        return GetQuestionsResponse.builder()
                .openQuestionResponses(collectOQ)
                .closedQuestionResponses(collectCQ)
                .multipleChoiceQuestionResponses(collectMCQ)
                .build();
    }

}
