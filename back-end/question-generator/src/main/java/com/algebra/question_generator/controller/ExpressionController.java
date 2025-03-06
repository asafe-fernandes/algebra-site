package com.algebra.question_generator.controller;

import com.algebra.question_generator.model.Question;
import com.algebra.question_generator.model.DTOs.*;
import com.algebra.question_generator.service.ExpressionService;
import com.algebra.question_generator.service.QuestionService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExpressionController {

    private ExpressionService expressionService;
    private QuestionService questionService;

    public ExpressionController(ExpressionService expressionService, QuestionService questionService) {
        this.expressionService = expressionService;
        this.questionService = questionService;
    }

    @PostMapping("/generate")
    public ResponseEntity<Question> generateExpression(@RequestBody QuestionRequestDTO questionRequestDTO) {
        Question response = expressionService.generateRandomExpression(questionRequestDTO);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<Question> getQuestion(@RequestParam double rating, @RequestParam double tolerance) {
        Question response = questionService.getByRating(rating, tolerance);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAll() {
        List<Question> response = questionService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Question> insert(@RequestBody QuestionDTO questionDTO) {
        Question response = questionService.insert(questionDTO);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    public void delete(@RequestParam String id) {
        this.questionService.delete(id);
    }
}
