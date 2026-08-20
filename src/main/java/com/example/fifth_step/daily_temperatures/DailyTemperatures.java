package com.example.fifth_step.daily_temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have
 * to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperaturesWithCustomArray(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int index = 0; index < temperatures.length; index++) {
            while (!stack.isEmpty() && temperatures[index] > temperatures[stack.peek()]) {
                int topIndex = stack.pop();
                answers[topIndex] = index - topIndex;
            }

            stack.push(index);
        }
        return answers;
    }

    public static int[] dailyTemperaturesWithCustomArray(int[] temperatures) {
        int len = temperatures.length;
        int[] answers = new int[len];
        int[] stack = new int[len];
        int top = -1;

        for (int index = 0; index < len; index++) {
            while (top >= 0 && temperatures[index] > temperatures[stack[top]]) {
                int prevIndex = stack[top--];
                answers[prevIndex] = index - prevIndex;
            }
            stack[++top] = index;
        }
        return answers;
    }
}
