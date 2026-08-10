package com.example.arrays_and_hash_tables.best_time_to_buy_and_sell_stock.maximum_subarray;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Kadane
 */
public class MaximumSubarray {
    public static void main(String[] args) {
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = new int[]{4, -1, 2, 1};

        System.out.println(maxSubArray(nums));
    }


    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] < nums[i]) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
