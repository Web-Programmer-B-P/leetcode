package com.example.arrays_and_hash_tables.best_time_to_buy_and_sell_stock.longest_consecutive_sequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 1, 1, 3, 2};

        System.out.println(longestConsecutiveWithSort(nums));
        System.out.println(longestConsecutiveWithHashSet(nums));
    }

    public static int longestConsecutiveWithSort(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int counter = 1;
        int result = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]) {
                continue;
            }

            if (nums[index] == nums[index - 1] + 1) {
                counter++;
            } else if (counter > result) {
                result = counter;
                counter = 1;
            }
        }
        return Math.max(result, counter);
    }

    public static int longestConsecutiveWithHashSet(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int item : nums) {
            set.add(item);
        }

        int best = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int counter = 1;
                int current = num;
                while (set.contains(current + 1)) {
                    current++;
                    counter++;
                }
                if (counter > best) {
                    best = counter;
                }
            }
        }

        return best;
    }
}
