package com.algebra.question_generator.model.DTOs;

public record QuestionRequestDTO(
        boolean hasParenthesis,
        boolean onlyIntegers,
        boolean onlyMatrices,
        int numberOfOperands,
        int rows,
        int cols) {
}
