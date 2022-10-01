package com.konfyrm.gigatester.questions.service;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import com.konfyrm.gigatester.questions.repository.OpenQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class OpenQuestionService {

    private static final Random RANDOM = new Random();

    private final OpenQuestionRepository openQuestionsRepository;

    @Autowired
    public OpenQuestionService(
            OpenQuestionRepository openQuestionsRepository
    ) {
        this.openQuestionsRepository = openQuestionsRepository;
    }

    public void saveQuestion(OpenQuestion question) {
        openQuestionsRepository.save(question);
    }

    public List<OpenQuestion> findAllQuestions(ExamTemplate exam) {
        return (List<OpenQuestion>) openQuestionsRepository.findAllByExamTemplate(exam);
    }

    public List<OpenQuestion> findRandomQuestions(ExamTemplate exam) {
        List<OpenQuestion> allQuestions = findAllQuestions(exam);
        List<OpenQuestion> questions = new LinkedList<>();
        int n = allQuestions.size();
        for (int i = 0; i < n; i++) {
            int ind = RANDOM.nextInt(allQuestions.size());
            questions.add(allQuestions.get(ind));
            allQuestions.remove(ind);
        }
        return questions;
    }

    public List<OpenQuestion> findRandomQuestions(ExamTemplate exam, int count) {
        List<OpenQuestion> allQuestions = findAllQuestions(exam);
        List<OpenQuestion> questions = new LinkedList<>();
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
