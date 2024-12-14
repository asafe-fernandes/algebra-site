package com.algebra.question_generator.controller;

import com.algebra.question_generator.model.ExpressionQuestion;
import com.algebra.question_generator.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpressionController {

    @Autowired
    private ExpressionService expressionService;

    // Endpoint para gerar uma expressão aleatória com número específico de operandos
    @GetMapping("/generate-expression")
    public ExpressionQuestion generateExpression(@RequestParam int numberOfOperands) {
        return expressionService.generateRandomExpression(numberOfOperands,3,3);
    }
}

