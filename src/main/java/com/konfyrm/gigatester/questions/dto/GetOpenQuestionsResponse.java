package com.konfyrm.gigatester.questions.dto;


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
public class GetOpenQuestionsResponse {

    private List<GetOpenQuestionResponse> openQuestionResponses;

    public static GetOpenQuestionsResponse entityToDto(List<OpenQuestion> openQuestions) {
        List<GetOpenQuestionResponse> collect = openQuestions.stream().
                map(GetOpenQuestionResponse::entityToDto)
                .collect(Collectors.toList());
        return GetOpenQuestionsResponse.builder()
                .openQuestionResponses(collect)
                .build();
    }

}
