package com.konfyrm.gigatester.questions.service;

import com.konfyrm.gigatester.exams.entity.ExamTemplate;
import com.konfyrm.gigatester.questions.entity.MultipleChoiceQuestion;
import com.konfyrm.gigatester.questions.entity.OpenQuestion;
import com.konfyrm.gigatester.questions.repository.MultipleChoiceQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class MultipleChoiceQuestionService {


    private static final Random RANDOM = new Random();

    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;

    @Autowired
    public MultipleChoiceQuestionService(
            MultipleChoiceQuestionRepository multipleChoiceQuestionRepository
    ) {
        this.multipleChoiceQuestionRepository = multipleChoiceQuestionRepository;
    }

    public void saveQuestion(MultipleChoiceQuestion question) {
        multipleChoiceQuestionRepository.save(question);
    }

    public List<MultipleChoiceQuestion> findAllQuestions(ExamTemplate exam) {
        return (List<MultipleChoiceQuestion>) multipleChoiceQuestionRepository.findAllByExamTemplate(exam);
    }

    public List<MultipleChoiceQuestion> findRandomQuestions(ExamTemplate exam) {
        List<MultipleChoiceQuestion> allQuestions = findAllQuestions(exam);
        List<MultipleChoiceQuestion> questions = new LinkedList<>();
        int n = allQuestions.size();
        for (int i = 0; i < n; i++) {
            int ind = RANDOM.nextInt(allQuestions.size());
            questions.add(allQuestions.get(ind));
            allQuestions.remove(ind);
        }
        return questions;
    }

    public List<MultipleChoiceQuestion> findRandomQuestions(ExamTemplate exam, int count) {
        List<MultipleChoiceQuestion> allQuestions = findAllQuestions(exam);
        List<MultipleChoiceQuestion> questions = new LinkedList<>();
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
