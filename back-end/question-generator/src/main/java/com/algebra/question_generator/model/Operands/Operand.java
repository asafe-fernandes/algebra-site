package com.algebra.question_generator.model.Operands;

public interface Operand {
  Operand sum(Operand other);

  Operand subtract(Operand other);

  Operand multiply(Operand other);
}
