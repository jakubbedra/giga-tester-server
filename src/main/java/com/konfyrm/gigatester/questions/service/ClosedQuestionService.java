package com.konfyrm.gigatester.questions.service;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.questions.entity.ClosedQuestion;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import com.konfyrm.gigatester.questions.repository.ClosedQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class ClosedQuestionService {

    private static final Random RANDOM = new Random();

    private final ClosedQuestionRepository closedQuestionRepository;

    @Autowired
    public ClosedQuestionService(
            ClosedQuestionRepository closedQuestionRepository
    ) {
        this.closedQuestionRepository = closedQuestionRepository;
    }

    public void saveQuestion(ClosedQuestion question) {
        closedQuestionRepository.save(question);
    }

    public List<ClosedQuestion> findAllQuestions(ExamTemplate exam) {
        return (List<ClosedQuestion>) closedQuestionRepository.findAllByExamTemplate(exam);
    }

    public List<ClosedQuestion> findRandomQuestions(ExamTemplate exam) {
        List<ClosedQuestion> allQuestions = findAllQuestions(exam);
        List<ClosedQuestion> questions = new LinkedList<>();
        int n = allQuestions.size();
        for (int i = 0; i < n; i++) {
            int ind = RANDOM.nextInt(allQuestions.size());
            questions.add(allQuestions.get(ind));
            allQuestions.remove(ind);
        }
        return questions;
    }

    public List<ClosedQuestion> findRandomQuestions(ExamTemplate exam, int count) {
        List<ClosedQuestion> allQuestions = findAllQuestions(exam);
        List<ClosedQuestion> questions = new LinkedList<>();
        int n = allQuestions.size();
        if (count > n) {
            throw new IllegalStateException(
                    "Given question count: " + count + " is greater then the number of available questions: " + n
            );
        }
        for (int i = 0; i < count; i++) {
            int ind = RANDOM.nextInt(allQuestions.size());
            questions.add(allQuestions.get(ind));
            allQuestions.remove(ind);
        }
        return questions;
    }

}
