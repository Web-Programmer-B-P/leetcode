package com.example.second_step.two_sum2;

import java.util.*;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers index1 and index2,
 * each incremented by one, as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 */
public class TwoSumInputArrayIsSorted {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 10};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            return new int[0];
        }

        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            } else if (sum > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return new int[0];
    }
}
