package com.konfyrm.gigatester.exams.repository;

import com.konfyrm.gigatester.exams.entity.SubjectGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectGroupRepository extends CrudRepository<SubjectGroup, Long> {
}
