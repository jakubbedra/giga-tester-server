package com.konfyrm.gigatester.exams.repository;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.exams.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTemplateRepository extends CrudRepository<ExamTemplate, Long> {

    Iterable<ExamTemplate> findAllBySubject(Subject subject);

}
