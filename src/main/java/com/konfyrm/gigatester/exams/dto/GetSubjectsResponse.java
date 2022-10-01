package com.konfyrm.gigatester.exams.dto;

import com.konfyrm.gigatester.exams.entity.Subject;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GetSubjectsResponse {

    private List<GetSubjectResponse> subjects;

    public static GetSubjectsResponse entityToDto(List<Subject> subjects) {
        List<GetSubjectResponse> responses = subjects.stream().map(GetSubjectResponse::entityToDto).collect(Collectors.toList());
        return GetSubjectsResponse.builder()
                .subjects(responses)
                .build();
    }

}

