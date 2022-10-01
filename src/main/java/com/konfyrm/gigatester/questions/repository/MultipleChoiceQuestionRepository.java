package com.konfyrm.gigatester.questions.repository;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.questions.entity.MultipleChoiceQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleChoiceQuestionRepository extends CrudRepository<MultipleChoiceQuestion, Long> {

    Iterable<MultipleChoiceQuestion> findAllByExamTemplate(ExamTemplate examTemplate);

}
