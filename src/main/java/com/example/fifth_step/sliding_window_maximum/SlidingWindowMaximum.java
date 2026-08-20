package com.example.fifth_step.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * You are given an array of integers nums,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // Если массив пуст или окно = 1, можно сразу вернуть копию массива,
        // но алгоритм корректно работает и для этих случаев.
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // храним индексы

        int resultIndex = 0; // индекс для записи в результат

        for (int index = 0; index < len; index++) {
            // Удаляем из начала индексы, которые вышли за пределы окна
            while (!deque.isEmpty() && deque.peekFirst() < index - k + 1) {
                deque.pollFirst();
            }

            // Удаляем из конца все индексы, чьи значения меньше или равны nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[index]) {
                deque.pollLast();
            }

            // Добавляем текущий индекс
            deque.offerLast(index);

            // Если окно полностью сформировано (i >= k-1), записываем максимум
            if (index >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
