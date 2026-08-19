package com.example.fifth_step.evaluate_reverse_polish_notation;

import java.util.ArrayDeque;
import java.util.Set;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * <p>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * <p>
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};

        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Set<String> OPERATORS = Set.of("+", "-", "*", "/");
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                int right = stackNumbers.pop();
                int left = stackNumbers.pop();
                switch (token) {
                    case "+":
                        stackNumbers.push(left + right);
                        break;
                    case "-":
                        stackNumbers.push(left - right);
                        break;
                    case "*":
                        stackNumbers.push(left * right);
                        break;
                    case "/":
                        stackNumbers.push(left / right);
                        break;
                    default:
                        throw new IllegalArgumentException("Нет такой операции");
                }
            } else {
                stackNumbers.push(Integer.parseInt(token));
            }
        }
        return stackNumbers.pop();
    }
}
