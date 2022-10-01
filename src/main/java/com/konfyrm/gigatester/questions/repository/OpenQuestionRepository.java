package com.konfyrm.gigatester.questions.repository;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenQuestionRepository extends CrudRepository<OpenQuestion, Long> {

    Iterable<OpenQuestion> findAllByExamTemplate(ExamTemplate examTemplate);

}
