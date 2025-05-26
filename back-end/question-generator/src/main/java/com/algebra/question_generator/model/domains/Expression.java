package com.algebra.question_generator.model.domains;

import com.algebra.question_generator.model.Operands.*;
import java.util.*;

public class Expression {

    private final Operand left;
    private final Operand right;
    private final char operator;

    public Expression(Operand left, Operand right, char operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public Operand evaluate() {
        return switch (operator) {
            case '+' -> left.sum(right);
            case '-' -> left.subtract(right);
            case '*' -> left.multiply(right);
            case '/' -> {
                if (left instanceof Rational && right instanceof Rational) {
                    yield ((Rational) left).divide(right);
                }
                throw new UnsupportedOperationException("Division not supported for matrices.");
            }
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }

    @Override
    public String toString() {
        return "(" + left + " " + operator + " " + right + ")";
    }

    // Helper methods for parsing expressions
    public static Operand parseExpression(String expr) {
        Stack<Operand> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (Character.isWhitespace(ch))
                continue;

            if (ch == '(') {
                operators.push(ch);
            } else if (ch == '[') {
                i = processMatrix(expr, i, operands); // Delegar parsing de matrizes
            } else if (Character.isDigit(ch) || ch == '/') {
                i = processRational(expr, i, operands); // Delegar parsing de números racionais
            } else if (ch == ')') {
                processClosingParenthesis(operators, operands); // Delegar processamento de parênteses fechando
            } else if ("+-*/".indexOf(ch) != -1) {
                processOperator(ch, operators, operands); // Delegar operadores
            } else {
                throw new IllegalArgumentException("Unexpected character in expression: " + ch);
            }
        }

        finalizeStacks(operators, operands); // Processar qualquer coisa restante

        if (operands.size() != 1) {
            throw new IllegalStateException("Invalid expression parsing. Operand stack size: " + operands.size());
        }

        return operands.pop();
    }

    private static int processMatrix(String expr, int startIndex, Stack<Operand> operands) {
        int end = findClosingBracket(expr, startIndex, '[', ']');
        String matrixStr = expr.substring(startIndex, end + 1);
        operands.push(parseMatrix(matrixStr));
        return end;
    }

    private static int processRational(String expr, int startIndex, Stack<Operand> operands) {
        StringBuilder number = new StringBuilder();
        int i = startIndex;
        while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '/')) {
            number.append(expr.charAt(i++));
        }
        operands.push(parseRational(number.toString()));
        return i - 1;
    }

    private static void processClosingParenthesis(Stack<Character> operators, Stack<Operand> operands) {
        while (!operators.isEmpty() && operators.peek() != '(') {
            processStacks(operands, operators);
        }
        if (operators.isEmpty() || operators.pop() != '(') {
            throw new IllegalArgumentException("Unmatched parentheses in expression.");
        }
    }

    private static void processOperator(char operator, Stack<Character> operators, Stack<Operand> operands) {
        while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(operator)) {
            processStacks(operands, operators);
        }
        operators.push(operator);
    }

    private static void finalizeStacks(Stack<Character> operators, Stack<Operand> operands) {
        while (!operators.isEmpty()) {
            processStacks(operands, operators);
        }
    }

    private static Rational parseRational(String s) {
        String[] parts = s.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = parts.length > 1 ? Integer.parseInt(parts[1]) : 1;
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero.");
        }
        return new Rational(numerator, denominator);
    }

    private static Matrix parseMatrix(String s) {
        try {
            // Remove espaços desnecessários e converte para array de arrays
            s = s.trim();
            s = s.replaceAll("\\s+", ""); // Remove espaços

            // Remova os colchetes externos e divida em linhas
            String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
            Rational[][] data = new Rational[rows.length][];

            for (int i = 0; i < rows.length; i++) {
                String row = rows[i].replace("[", "").replace("]", ""); // Remove brackets da linha
                String[] elements = row.split(",");
                data[i] = new Rational[elements.length];

                for (int j = 0; j < elements.length; j++) {
                    data[i][j] = parseRational(elements[j]);
                }
            }

            return new Matrix(data);

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid matrix format: " + s, e);
        }
    }

    private static void processStacks(Stack<Operand> operands, Stack<Character> operators) {
        if (operands.size() < 2 || operators.isEmpty()) {
            throw new IllegalStateException("Invalid expression structure during processing.");
        }
        Operand right = operands.pop();
        Operand left = operands.pop();
        char operator = operators.pop();
        operands.push(new Expression(left, right, operator).evaluate());
    }

    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    private static int findClosingBracket(String expr, int start, char open, char close) {
        int count = 1;
        for (int i = start + 1; i < expr.length(); i++) {
            if (expr.charAt(i) == open)
                count++;
            else if (expr.charAt(i) == close)
                count--;
            if (count == 0)
                return i;
        }
        throw new IllegalArgumentException("Unmatched " + open + " in expression.");
    }

    public static void main(String[] args) {
        // Test expressions
        String expr = "([[1/2, 1/3],[2/5, 3/4]] + [[1/1, 1/1],[1/1, 1/1]]) * 2/3";
        try {
            Operand result = parseExpression(expr);
            System.out.println("Expression: " + expr);
            System.out.println("Result: " + result.toString());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
