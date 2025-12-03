package com.algebra.question_generator.model;

public record QuestionRequestDTO(
    boolean hasParenthesis,
    boolean onlyIntegers,
    boolean onlyMatrices,
    boolean primeMultiplerLess10,
    int numberOfOperands,
    int maxRows,
    int maxCols) {
}
