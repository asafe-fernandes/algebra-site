package com.algebra.question_generator.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.algebra.question_generator.model.Question;
import com.algebra.question_generator.model.DTOs.*;
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

    public Question getByRating(GetRequestDTO getRequestDTO) {
        Random rand = new Random();

        double target = getRequestDTO.target();
        double tolerance = getRequestDTO.tolerance();

        double minRating = target - tolerance;
        double maxRating = target + tolerance;
        List<Question> questions = this.questionRepository.findQuestionByRating(minRating, maxRating);

        Question result = questions.get(rand.nextInt(questions.size()));
        return result;

    }

    public Question insert(QuestionDTO questionDTO) {
        Question result = this.questionRepository.insert(new Question(questionDTO));
        return result;
    }

    public void delete(String id) {
        this.questionRepository.deleteById(id);

    }
}
