package com.algebra.question_generator.model;

public interface Operand {
    Operand sum(Operand other);
    Operand subtract(Operand other);
    Operand multiply(Operand other);
    Operand divide(Operand other);
}
