package com.konfyrm.gigatester.exams.entity;

import com.konfyrm.gigatester.questions.entity.ClosedQuestion;
import com.konfyrm.gigatester.questions.entity.MultipleChoiceQuestion;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exam_templates")
public class ExamTemplate {

    /**
     * The unique identifier of the template
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /**
     * The subject of the exam
     */
    @ManyToOne
    private Subject subject;

    /**
     * The name of the exam, for instance: "test 1"
     */
    @Column(name = "exam_name")
    private String name;

    /**
     * Number of closed questions
     */
    private int closedQuestionsCount;

    /**
     * Number of multiple-choice questions
     */
    private int multipleChoiceQuestionsCount;

    /**
     * Number of open questions
     */
    private int openQuestionsCount;

    @OneToMany
    private List<ClosedQuestion> closedQuestions;

    @OneToMany
    private List<MultipleChoiceQuestion> multipleChoiceQuestions;

    @OneToMany
    private List<OpenQuestion> openQuestions;

}
