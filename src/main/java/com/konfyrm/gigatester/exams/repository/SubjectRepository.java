package com.konfyrm.gigatester.exams.repository;

import com.konfyrm.gigatester.exams.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
