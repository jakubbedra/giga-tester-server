package com.konfyrm.gigatester.exams.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "subject_groups")
public class SubjectGroup {

    /**
     * The unique identifier of the subject group
     */
    @Id
    private UUID uuid;

    /**
     * The name of the subject group
     */
    private String name;

    /**
     * The subjects of the subject group
     */
    @ManyToMany
    private List<Subject> subjects;

}
