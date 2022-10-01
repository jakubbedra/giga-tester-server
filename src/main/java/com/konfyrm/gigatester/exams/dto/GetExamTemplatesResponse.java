package com.konfyrm.gigatester.exams.dto;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GetExamTemplatesResponse {

    private List<GetExamTemplateResponse> examTemplates;

    public static GetExamTemplatesResponse entityToDto(List<ExamTemplate> examTemplates) {
        List<GetExamTemplateResponse> responses = examTemplates.stream().map(GetExamTemplateResponse::entityToDto).collect(Collectors.toList());
        return GetExamTemplatesResponse.builder()
                .examTemplates(responses)
                .build();
    }

}
