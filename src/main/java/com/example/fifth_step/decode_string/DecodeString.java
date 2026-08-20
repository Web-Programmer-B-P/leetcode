package com.example.fifth_step.decode_string;

import java.util.ArrayDeque;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
 * being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces,
 * square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits
 * and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 105.
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
        System.out.println(decodeStringRecursion(s));
        System.out.println(decodeStringArray(s));
    }

    public static String decodeString(String s) {
        ArrayDeque<StringBuilder> stringStack = new ArrayDeque<>();
        ArrayDeque<Integer> numberStack = new ArrayDeque<>();
        StringBuilder currentRow = new StringBuilder();
        int repeatCounter = 0;

        for (char symbol : s.toCharArray()) {
            if (Character.isDigit(symbol)) {
                repeatCounter = repeatCounter * 10 + (symbol - '0'); //Обработка многозначных чисел.
            } else if (symbol == '[') {
                numberStack.push(repeatCounter);
                repeatCounter = 0;
                stringStack.push(currentRow);
                currentRow = new StringBuilder();
            } else if (symbol == ']') {
                int count = numberStack.pop();
                StringBuilder inner = stringStack.pop();
                currentRow = new StringBuilder(inner + currentRow.toString().repeat(count));
            } else {
                currentRow.append(symbol);
            }
        }
        return currentRow.toString();
    }


    public static String decodeStringRecursion(String s) {
        int[] index = new int[]{0};
        return decode(s, index).toString();
    }

    private static StringBuilder decode(String s, int[] index) {
        StringBuilder currentRow = new StringBuilder();
        int k = 0;
        while (index[0] < s.length()) {
            char symbol = s.charAt(index[0]);
            if (Character.isDigit(symbol)) {
                k = k * 10 + (symbol - '0');
                index[0]++;
            } else if (symbol == '[') {
                index[0]++;
                StringBuilder inner = decode(s, index);
                while (k-- > 0) {
                    currentRow.append(inner);
                }
//                currentRow = new StringBuilder(inner + currentRow.toString().repeat(k));
                k = 0;
            } else if (symbol == ']') {
                index[0]++;
                return currentRow;
            } else {
                currentRow.append(symbol);
                index[0]++;
            }
        }
        return currentRow;
    }

    public static String decodeStringArray(String s) {
        int len = s.length();
        int[] numberStack = new int[len];
        StringBuilder[] stringStack = new StringBuilder[len];
        int numberTop = -1, stringTop = -1;
        StringBuilder currentAccamulatedRow = new StringBuilder();
        int counterOfRepeat = 0;

        for (char symbol : s.toCharArray()) {
            if (symbol >= '0' && symbol <= '9') {
                counterOfRepeat = counterOfRepeat * 10 + (symbol - '0');
            } else if (symbol == '[') {
                numberStack[++numberTop] = counterOfRepeat;
                stringStack[++stringTop] = currentAccamulatedRow;
                currentAccamulatedRow = new StringBuilder();
                counterOfRepeat = 0;
            } else if (symbol == ']') {
                int repeat = numberStack[numberTop--];
                StringBuilder prev = stringStack[stringTop--];
                while (repeat-- > 0) prev.append(currentAccamulatedRow);
                currentAccamulatedRow = prev;
            } else {
                currentAccamulatedRow.append(symbol);
            }
        }
        return currentAccamulatedRow.toString();
    }
}

















