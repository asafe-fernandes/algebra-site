package com.algebra.question_generator.controller;

import com.algebra.question_generator.model.domains.Question;
import com.algebra.question_generator.model.DTOs.*;
import com.algebra.question_generator.service.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAll() {
        List<Question> response = this.questionService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<Question> getQuestion(@RequestParam double rating, @RequestParam double tolerance) {
        Question response = this.questionService.getByRating(rating, tolerance);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/generate")
    public ResponseEntity<Question> generateExpression(@RequestBody QuestionRequestDTO questionRequestDTO) {
        Question question = expressionService.generateRandomExpression(questionRequestDTO);
        Question response = this.questionService.insert(question);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Question> insert(@RequestBody QuestionDTO questionDTO) {
        Question question = new Question(questionDTO);
        Question response = this.questionService.insert(question);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@PathVariable String id, @RequestBody QuestionDTO questionDTO) {
        Question question = new Question(questionDTO);
        Question response = this.questionService.update(id, question);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Question> delete(@PathVariable String id) {
        Question response = this.questionService.delete(id);
        return ResponseEntity.ok().body(response);
    }
}
