package com.konfyrm.gigatester.exams.dto;

import com.konfyrm.gigatester.exams.entity.Subject;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GetSubjectResponse {

    private Long id;
    private String name;

    public static GetSubjectResponse entityToDto(Subject subject) {
        return GetSubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();
    }

}
