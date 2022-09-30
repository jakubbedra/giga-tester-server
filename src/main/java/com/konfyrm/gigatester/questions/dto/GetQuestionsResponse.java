package com.konfyrm.gigatester.questions.dto;

import lombok.*;

import java.util.List;

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

}
