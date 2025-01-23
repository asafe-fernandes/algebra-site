package com.algebra.question_generator.controller;

import com.algebra.question_generator.model.Question;
import com.algebra.question_generator.model.QuestionRequestDTO;
import com.algebra.question_generator.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expressions")
public class ExpressionController {

  @Autowired
  private ExpressionService expressionService;

  @GetMapping
  public ResponseEntity<Question> generateExpression(@RequestBody QuestionRequestDTO questionRequestDTO) {

    Question response = expressionService.generateRandomExpression(questionRequestDTO);
    return ResponseEntity.ok().body(response);
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
