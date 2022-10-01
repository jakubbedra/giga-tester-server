package com.konfyrm.gigatester.questions.repository;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.questions.entity.ClosedQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClosedQuestionRepository extends CrudRepository<ClosedQuestion, Long> {

    Iterable<ClosedQuestion> findAllByExamTemplate(ExamTemplate examTemplate);

}
