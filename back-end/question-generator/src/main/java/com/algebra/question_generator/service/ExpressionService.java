package com.algebra.question_generator.service;

import com.algebra.question_generator.model.Operands.*;
import com.algebra.question_generator.model.domains.*;
import com.algebra.question_generator.model.DTOs.*;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

@Service
public class ExpressionService {
    private final Random rand = new Random();

    // Gera uma expressão aleatória com um número especificado de operandos
    public Question generateRandomExpression(QuestionRequestDTO questionRequestDTO) {
        boolean hasParenthesis = questionRequestDTO.hasParenthesis();
        boolean onlyIntegers = questionRequestDTO.onlyIntegers();
        boolean onlyMatrices = questionRequestDTO.onlyMatrices();
        int numberOfOperands = questionRequestDTO.numberOfOperands();
        int rows = questionRequestDTO.rows();
        int cols = questionRequestDTO.cols();

        boolean multi = rows == cols ? true : false;

        if (numberOfOperands < 2)
            throw new IllegalArgumentException("Number of operands needs to be at least 2.");

        List<Operand> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        for (int i = 0; i < numberOfOperands; i++) {
            operands.add(generateRandomOperand(onlyMatrices, onlyIntegers, rows, cols));
            if (i < numberOfOperands - 1) {
                operators.add(getRandomOperator(multi));
            }
        }

        String expression = buildExpression(operands, operators, hasParenthesis);
        String answer = Expression.parseExpression(expression).toString();
        double rating = calculateRating(questionRequestDTO);

        return new Question(expression, answer, rating);
    }

    public double calculateRating(QuestionRequestDTO qDTO) {
        double rating = 0;
        rating += !qDTO.onlyIntegers() ? 1 : 0;
        rating += qDTO.numberOfOperands() > 4 ? qDTO.numberOfOperands() * 0.5 : qDTO.numberOfOperands() * 0.7;
        rating += qDTO.hasParenthesis() ? 0.5 : 0;
        rating += qDTO.onlyMatrices() ? 0.5 : 1;
        rating += qDTO.rows() * qDTO.cols() > 9 ? 1.5 : 1;

        return Math.max(1, Math.min(10, rating));
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

    private Operand generateRandomOperand(boolean onlyMatrices, boolean onlyIntegers, int rows, int cols) {

        boolean condicional = onlyMatrices ? false : rand.nextBoolean();
        if (condicional) {
            return generateRandomRational(onlyIntegers);
        } else {
            return generateRandomMatrix(onlyIntegers, rows, cols);
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

    private char getRandomOperator(boolean multi) {

        char[] operators = { '+', '-', '*' };
        return multi ? operators[rand.nextInt(operators.length)] : operators[rand.nextInt(operators.length - 1)];

    }

}
