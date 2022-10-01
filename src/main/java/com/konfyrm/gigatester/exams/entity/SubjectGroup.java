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
@Table(name = "subject_groups")
public class SubjectGroup {

    /**
     * The unique identifier of the subject group
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the subject group
     */
    @Column(name = "subject_group_name")
    private String name;

    /**
     * The subjects of the subject group
     */
    @ManyToMany
    private List<Subject> subjects;

}
