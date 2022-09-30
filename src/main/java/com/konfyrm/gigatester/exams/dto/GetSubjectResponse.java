package com.konfyrm.gigatester.exams.dto;

import com.konfyrm.gigatester.exams.entity.Subject;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GetSubjectResponse {

    private UUID uuid;
    private String name;

    public static GetSubjectResponse entityToDto(Subject subject) {
        return GetSubjectResponse.builder()
                .uuid(subject.getUuid())
                .name(subject.getName())
                .build();
    }

}
