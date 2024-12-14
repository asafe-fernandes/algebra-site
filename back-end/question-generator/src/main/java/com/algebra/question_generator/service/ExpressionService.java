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
    public ExpressionQuestion generateRandomExpression(int numberOfOperands,int maxRows, int maxCols) {
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
            operands.add(generateRandomOperand(rows,cols));
            if (i < numberOfOperands - 1) { // Não gerar operador após o último operando
                operators.add(getRandomOperator());
            }
        }

        // Construir a expressão
        String expression = buildExpressionWithParentheses(operands, operators);
        String answer = Expression.parseExpression(expression).toString();
        return new ExpressionQuestion(expression,answer);
    }

    private String buildExpressionWithParentheses(List<Operand> operands, List<Character> operators) {
        // Começa com o primeiro operando
        StringBuilder expression = new StringBuilder();
        expression.append(operands.get(0));

        // Itera sobre os operadores e operandos
        for (int i = 0; i < operators.size(); i++) {
            // Decidir aleatoriamente se a subexpressão será envolvida em parênteses
            if (rand.nextBoolean()) {
                expression.append(" ").append(operators.get(i)).append(" (");
                expression.append(operands.get(i + 1));
                expression.append(")");
            } else {
                expression.append(" ").append(operators.get(i)).append(" ").append(operands.get(i + 1));
            }
        }

        return expression.toString();
    }

    private Operand generateRandomOperand(int rows,int cols) {
        // Sorteia se o operando será uma matriz ou um número racional
        if (rand.nextBoolean()) {
            return generateRandomMatrix(rows,cols); // Gera uma matriz aleatória
        } else {
            return generateRandomRational(); // Gera um número racional aleatório
        }
    }

    private Operand generateRandomMatrix(int rows, int cols) {
        // Gera uma matriz de tamanho aleatório entre 1x1 e 5x5 (ou maior, conforme desejado)
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
        char[] operators = {'+', '-', '*'};
        return operators[rand.nextInt(operators.length)];
    }

}
