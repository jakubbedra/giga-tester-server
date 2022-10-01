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
@Table(name = "multiple_choice_questions")
public class MultipleChoiceQuestion {

    /**
     * The entity id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
     * Presented answers to the question in json format
     */
    private String answers;

    /**
     * The indices of the correct answers in answers list in JSON format
     */
    private String correctAnswerIndices;

}
