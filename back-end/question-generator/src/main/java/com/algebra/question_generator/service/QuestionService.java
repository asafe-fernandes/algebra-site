package com.algebra.question_generator.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.algebra.question_generator.model.domains.Question;
import com.algebra.question_generator.model.Exceptions.*;
import com.algebra.question_generator.repository.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAll() {

        List<Question> response = this.questionRepository.findAll();
        return response;
    }

    public Question getByRating(double target, double tolerance) {
        Random rand = new Random();

        double minRating = target - tolerance;
        double maxRating = target + tolerance;
        List<Question> questions = this.questionRepository.findQuestionByRating(minRating, maxRating);

        Question result = questions.get(rand.nextInt(questions.size()));
        return result;

    }

    public Question insert(Question question) {
        Question result = this.questionRepository.insert(question);
        return result;
    }

    public Question update(String id, Question other) {
        Question question = this.questionRepository.findById(id)
                .orElseThrow(QuestionNotFoundException::new);

        if (!other.getRightAnswer().isEmpty())
            question.setRightAnswer(other.getRightAnswer());
        if (!other.getExpression().isEmpty())
            question.setExpression(other.getExpression());
        if (other.getRating() != 0.0)
            question.setRating(other.getRating());

        this.questionRepository.save(question);
        return question;
    }

    public Question delete(String id) {
        Question toBeDeletedQuestion = this.questionRepository.findById(id)
                .orElseThrow(QuestionNotFoundException::new);

        this.questionRepository.delete(toBeDeletedQuestion);
        return toBeDeletedQuestion;
    }
}
