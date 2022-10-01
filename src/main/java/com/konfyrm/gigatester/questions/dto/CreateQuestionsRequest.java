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
public class CreateQuestionsRequest {

    private List<CreateOpenQuestionRequest> openQuestionRequests;
    private List<CreateClosedQuestionRequest> closedQuestionRequests;
    private List<CreateMultipleChoiceQuestionRequest> multipleChoiceQuestionRequests;

    public static List<OpenQuestion> dtoToEntityOpenQuestions(CreateQuestionsRequest request) {
        return request.openQuestionRequests.stream()
                .map(CreateOpenQuestionRequest::dtoToEntity)
                .collect(Collectors.toList());
    }

    public static List<ClosedQuestion> dtoToEntityClosedQuestions(CreateQuestionsRequest request) {
        return request.closedQuestionRequests.stream()
                .map(CreateClosedQuestionRequest::dtoToEntity)
                .collect(Collectors.toList());
    }

    public static List<MultipleChoiceQuestion> dtoToEntityMultipleChoiceQuestions(CreateQuestionsRequest request){
        return request.multipleChoiceQuestionRequests.stream()
                .map(CreateMultipleChoiceQuestionRequest::dtoToEntity)
                .collect(Collectors.toList());
    }

}
