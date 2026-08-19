package com.example.fifth_step.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(generateParenthesis(n));
    }


    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Если использовали все пары – добавляем строку
        if (open == max && close == max) {
            result.add(current.toString());
            return;
        }

        // Добавляем открывающую, если можно
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // откат
        }

        // Добавляем закрывающую, если она не нарушит правильность
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
