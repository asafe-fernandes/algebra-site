package com.algebra.question_generator.controller;

import com.algebra.question_generator.model.ExpressionQuestion;
import com.algebra.question_generator.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate-expression")
public class ExpressionController {

  @Autowired
  private ExpressionService expressionService;

  @GetMapping
  public ExpressionQuestion generateExpression(
      @RequestParam int numberOfOperands,
      @RequestParam(defaultValue = "true") String onlyIntegers,
      @RequestParam(defaultValue = "false") String hasParenthesis) {

    return expressionService.generateRandomExpression(Boolean.getBoolean(hasParenthesis),
        Boolean.getBoolean(onlyIntegers), numberOfOperands, 3, 3);
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
