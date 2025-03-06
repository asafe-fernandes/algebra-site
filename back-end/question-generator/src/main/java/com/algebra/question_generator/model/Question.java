package com.algebra.question_generator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.algebra.question_generator.model.DTOs.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "QuestionsDB")
@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id
    String id;
    private String expression;
    private String rightAnswer;
    private double rating;

    public Question(String expression, String rightAnswer, double rating) {
        this.expression = expression;
        this.rightAnswer = rightAnswer;
        this.rating = rating;
    }

    public Question(QuestionDTO questionDTO) {
        this.expression = questionDTO.expression();
        this.rightAnswer = questionDTO.rightAnswer();
        this.rating = questionDTO.rating();
    }
}
