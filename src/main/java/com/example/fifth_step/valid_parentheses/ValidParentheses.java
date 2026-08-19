package com.example.fifth_step.valid_parentheses;

import java.util.ArrayDeque;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";

        System.out.println("Строка: " + s + " валидна: " + isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
