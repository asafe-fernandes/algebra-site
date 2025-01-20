package com.algebra.question_generator.service;

import com.algebra.question_generator.model.*;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

@Service
public class ExpressionService {
  private final Random rand = new Random();

  // Gera uma expressão aleatória com um número especificado de operandos
  public ExpressionQuestion generateRandomExpression(
      boolean hasParenthesis,
      boolean onlyIntegers,
      int numberOfOperands,
      int maxRows,
      int maxCols) {

    if (numberOfOperands < 2) {
      throw new IllegalArgumentException("O número de operandos deve ser pelo menos 2.");
    }

    List<Operand> operands = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    int rows = rand.nextInt(maxCols) + 1;
    int cols = rand.nextInt(maxRows) + 1; // Gera um número aleatório entre 1 e 5 para as colunas

    for (int i = 0; i < numberOfOperands; i++) {
      operands.add(generateRandomOperand(onlyIntegers, rows, cols));
      if (i < numberOfOperands - 1) { // Não gerar operador após o último operando
        operators.add(getRandomOperator());
      }
    }

    // Construir a expressão
    String expression = buildExpression(operands, operators, hasParenthesis);
    String answer = Expression.parseExpression(expression).toString();
    return new ExpressionQuestion(expression, answer);
  }

  public String buildExpression(List<Operand> operands, List<Character> operators, boolean putParenthesis) {
    StringBuilder expression = new StringBuilder();
    int i = 0; // Índice dos operandos e operadores

    while (i < operators.size()) {
      // Adiciona o primeiro operando (ou o próximo)
      if (i == 0) {
        expression.append(operands.get(i));
      }

      // Se putParenthesis for verdadeiro, tenta adicionar parênteses
      if (putParenthesis && i < operands.size() - 2 && rand.nextBoolean()) {
        // Garante que haja pelo menos 2 operandos dentro dos parênteses
        int operandsInParens = rand.nextInt(operands.size() - i - 1) + 2; // Pelo menos 2 operandos

        // Adiciona o operador antes dos parênteses
        expression.append(" ").append(operators.get(i)).append(" (");

        // Adiciona os operandos dentro dos parênteses
        for (int j = 0; j < operandsInParens && i + j + 1 < operands.size(); j++) {
          if (j > 0) {
            expression.append(" ").append(operators.get(i + j)).append(" ");
          }
          expression.append(operands.get(i + j + 1));
        }

        expression.append(")");
        i += operandsInParens;
      } else {
        expression.append(" ").append(operators.get(i)).append(" ").append(operands.get(i + 1));
        i++;
      }
    }

    return expression.toString();
  }

  private Operand generateRandomOperand(boolean onlyIntegers, int rows, int cols) {
    if (rand.nextBoolean()) {
      return generateRandomMatrix(onlyIntegers, rows, cols);
    } else {
      return generateRandomRational(onlyIntegers);
    }
  }

  private Operand generateRandomMatrix(boolean onlyIntegers, int rows, int cols) {
    Matrix matrix = new Matrix(rows, cols);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix.setValue(i, j, generateRandomRational(onlyIntegers));
      }
    }
    return matrix;
  }

  private Rational generateRandomRational(boolean onlyIntegers) {
    int numerator = rand.nextInt(10) + 1;
    int denominator = onlyIntegers ? 1 : rand.nextInt(10) + 1;
    return new Rational(numerator, denominator);
  }

  private char getRandomOperator() {
    char[] operators = { '+', '-', '*' };
    return operators[rand.nextInt(operators.length)];
  }

}
