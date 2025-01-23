package com.algebra.question_generator.model;

public record QuestionRequestDTO(
    boolean hasParenthesis,
    boolean onlyIntegers,
    boolean onlyMatrices,
    int numberOfOperands,
    int maxRows,
    int maxCols) {
}
