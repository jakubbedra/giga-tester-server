package com.konfyrm.gigatester.questions.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateQuestionsRequest {

    private List<CreateOpenQuestionRequest> openQuestionRequests;
    private List<CreateClosedQuestionRequest> closedQuestionRequests;
    private List<CreateMultipleChoiceQuestionRequest> multipleChoiceQuestionRequests;

}
