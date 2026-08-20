package com.example.fifth_step.largest_rectangle_in_histogram;

import java.util.ArrayDeque;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        // Добавляем фиктивный столбец высотой 0 в конец (для обработки остатков)
        int[] extended = new int[heights.length + 1];
        System.arraycopy(heights, 0, extended, 0, heights.length);
        extended[heights.length] = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int index = 0; index < extended.length; index++) {
            while (!stack.isEmpty() && extended[index] < extended[stack.peek()]) {
                int top = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = index - left - 1;
                maxArea = Math.max(maxArea, heights[top] * width);
            }
            stack.push(index);
        }
        return maxArea;
    }
}
