package com.konfyrm.gigatester.exams.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "subjects")
public class Subject {

    /**
     * The unique identifier of the subject
     */
    @Id
    private UUID uuid;

    /**
     * The name of the subject
     */
    private String name;

    /**
     * All the available exams from the subject
     */
    @OneToMany
    private List<ExamTemplate> examTemplates;

    /**
     * Groups to which the given subject belongs to
     */
    @ManyToMany
    private List<SubjectGroup> subjectGroups;

}
