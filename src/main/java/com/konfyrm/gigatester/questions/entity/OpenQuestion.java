package com.konfyrm.gigatester.questions.entity;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.questions.QuestionLabel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "open_questions")
public class OpenQuestion {

    /**
     * The entity id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * The exam to which this question belongs
     */
    @ManyToOne
    private ExamTemplate examTemplate;

    /**
     * Tells where the question came from
     */
    private QuestionLabel label;

    /**
     * The content of the question
     */
    private String content;

    /**
     * Example answer to the question
     */
    private String sampleAnswer;

}
