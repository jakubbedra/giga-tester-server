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
public class CreateSubjectRequest {

    private String name;

    public static Subject dtoToEntity(CreateSubjectRequest request) {
        return Subject.builder()
                .uuid(UUID.randomUUID())
                .name(request.name)
                .build();
    }

}
