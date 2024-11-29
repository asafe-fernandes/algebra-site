package com.algebra.question_generator.controller;

import org.springframework.web.bind.annotation.RestController;

import com.algebra.question_generator.service.MatrixExpressionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MatrixQuestionController {

  private final MatrixExpressionService service;

  public MatrixQuestionController(MatrixExpressionService service) {
    this.service = service;
  }

  @GetMapping("/generate-question")
  public String getMethodName(
      @RequestParam(defaultValue = "3") int numMatrices,
      @RequestParam(defaultValue = "2") int rows,
      @RequestParam(defaultValue = "2") int columns,
      @RequestParam(defaultValue = "1") int min,
      @RequestParam(defaultValue = "10") int max) {
    return service.generateExpression(numMatrices, rows, columns, min, max);
  }

}
