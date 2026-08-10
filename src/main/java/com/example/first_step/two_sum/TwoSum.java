package com.example.arrays_and_hash_tables.best_time_to_buy_and_sell_stock.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Problem:
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * Задача:
     * Дан массив целых чисел nums и целое число target. Верните индексы двух чисел таких, чтобы их сумма была равна target.
     * Гарантируется, что существует ровно одно решение. Нельзя использовать один и тот же элемент дважды.
     * Можно вернуть ответ в любом порядке.
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 15, 7, 45};
        int target = 9;
        System.out.println(Arrays.toString(twoSumMap(nums, target)));
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (!map.containsKey(x)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(x), i};
            }
        }
        return new int[0];
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
