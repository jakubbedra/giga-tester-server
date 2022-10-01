package com.konfyrm.gigatester.exams.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class Subject {

    /**
     * The unique identifier of the subject
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the subject
     */
    @Column(name = "subject_name")
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
