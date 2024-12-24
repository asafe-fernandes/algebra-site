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
  public ExpressionQuestion generateRandomExpression(int numberOfOperands, int maxRows, int maxCols) {
    if (numberOfOperands < 2) {
      throw new IllegalArgumentException("O número de operandos deve ser pelo menos 2.");
    }

    // Lista para armazenar os operandos e os operadores
    List<Operand> operands = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    int rows = rand.nextInt(5) + 1; // Gera um número aleatório entre 1 e 5 para as linhas
    int cols = rand.nextInt(5) + 1; // Gera um número aleatório entre 1 e 5 para as colunas

    // Gerar operandos aleatórios
    for (int i = 0; i < numberOfOperands; i++) {
      operands.add(generateRandomOperand(rows, cols));
      if (i < numberOfOperands - 1) { // Não gerar operador após o último operando
        operators.add(getRandomOperator());
      }
    }

    // Construir a expressão
    String expression = buildExpressionWithParentheses(operands, operators);
    String answer = Expression.parseExpression(expression).toString();
    return new ExpressionQuestion(expression, answer);
  }

  private String buildExpressionWithParentheses(List<Operand> operands, List<Character> operators) {
    StringBuilder expression = new StringBuilder();
    int i = 0; // Índice inicial para operadores e operandos

    while (i < operators.size()) {
      // Adiciona o primeiro operando (ou o próximo fora de um grupo)
      if (i == 0) {
        expression.append(operands.get(i));
      }

      // Decide aleatoriamente se criará um grupo de parênteses
      if (rand.nextBoolean()) {
        expression.append(" ").append(operators.get(i)).append(" (");

        // Inclui o primeiro operando no grupo
        expression.append(operands.get(i + 1));
        i++;

        // Garante pelo menos mais um operando no grupo (para garantir 2 operandos
        // dentro)
        if (i < operators.size()) {
          expression.append(" ").append(operators.get(i)).append(" ").append(operands.get(i + 1));
          i++;
        }

        // Garante que sempre existam pelo menos dois operandos dentro dos parênteses
        // Se necessário, adiciona mais operandos e operadores
        while (i < operators.size() && rand.nextBoolean()) {
          expression.append(" ").append(operators.get(i)).append(" ").append(operands.get(i + 1));
          i++;
        }

        expression.append(")"); // Fecha o grupo
      } else {
        // Adiciona a operação atual sem criar parênteses
        expression.append(" ").append(operators.get(i)).append(" ").append(operands.get(i + 1));
        i++;
      }
    }

    return expression.toString();
  }

  private Operand generateRandomOperand(int rows, int cols) {
    // Sorteia se o operando será uma matriz ou um número racional
    if (rand.nextBoolean()) {
      return generateRandomMatrix(rows, cols); // Gera uma matriz aleatória
    } else {
      return generateRandomRational(); // Gera um número racional aleatório
    }
  }

  private Operand generateRandomMatrix(int rows, int cols) {
    // Gera uma matriz de tamanho aleatório entre 1x1 e 5x5 (ou maior, conforme
    // desejado)
    Matrix matrix = new Matrix(rows, cols);

    // Preenche a matriz com valores racionais aleatórios
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix.setValue(i, j, generateRandomRational());
      }
    }
    return matrix;
  }

  private Rational generateRandomRational() {
    // Gera um número racional aleatório (numerador e denominador entre 1 e 10)
    int numerator = rand.nextInt(10) + 1;
    int denominator = rand.nextInt(10) + 1;
    return new Rational(numerator, denominator);
  }

  private char getRandomOperator() {
    // Gera um operador aleatório entre +, -, * e /
    char[] operators = { '+', '-', '*' };
    return operators[rand.nextInt(operators.length)];
  }

}
