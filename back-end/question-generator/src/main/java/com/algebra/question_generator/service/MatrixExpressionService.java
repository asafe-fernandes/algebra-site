package com.algebra.question_generator.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.algebra.question_generator.model.MatrixQuestion;
import com.algebra.question_generator.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MatrixExpressionService {
  private final Random random = new Random();
  private final ObjectMapper objectMapper = new ObjectMapper();

  public String generateExpression(int numMatrices, int rows, int columns, int min, int max) {
    MatrixQuestion question = generateExpressionQuestion(numMatrices, rows, columns, min, max);
    try {
      return objectMapper.writeValueAsString(question);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Erro ao gerar JSON da questão", e);
    }
  }

  private String getRandomOperation(String[] operations) {
    return operations[random.nextInt(operations.length)];
  }

  private MatrixQuestion generateExpressionQuestion(int numMatrices, int rows, int columns, int min, int max) {
    List<Matrix> matrices = new ArrayList<>();
    StringBuilder operationsBuilder = new StringBuilder();
    String[] operations = { "+", "*" };

    for (int i = 0; i < numMatrices; i++) {
      matrices.add(new Matrix(rows, columns, min, max));
    }

    Matrix result = matrices.get(0);

    for (int i = 0; i < numMatrices; i++) {

      String operation = getRandomOperation(operations);
      operationsBuilder.append("M ").append(i + 1);

      if (random.nextBoolean()) {
        operationsBuilder.append("t");
        result.transpose();
      }

      if (i != numMatrices - 1) {
        operationsBuilder.append(operation);
      }
      result = applyOperation(result, matrices.get(i), operation);

      // if (operation.equals("t")) {
      // result = applyOperation(result, matrices.get(i), operation);
      // String nextOperation = getRandomOperation(new String[]{"+","*"});
      // }
    }

    return new MatrixQuestion(
        "Calcule a seguinte expresssao: ",
        matrices,
        operationsBuilder.toString(),
        result);
  }

  private Matrix applyOperation(Matrix matrixA, Matrix matrixB, String operation) {
    switch (operation) {
      case "+":

        return matrixA.add(matrixB);
      case "*":

        return matrixA.multiply(matrixB);
      // case "t":
      // // String nextOperation = getRandomOperation(new String[] { "+", "*" });
      // // return applyOperation(matrixA.transpose(), matrixB, nextOperation);
      // return matrixA.transpose();
      default:
        throw new IllegalArgumentException("Operacao desconhecida: " + operation);
    }
  }

}
