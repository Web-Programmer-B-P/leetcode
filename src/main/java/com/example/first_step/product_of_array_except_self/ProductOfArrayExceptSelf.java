package com.example.first_step.product_of_array_except_self;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4};
        int[] nums = new int[]{-1, 1, 0, -3, 3};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }

        int[] ans = new int[len];

        ans[0] = 1;
        for (int l = 1; l < len; l++) {
            ans[l] = ans[l - 1] * nums[l - 1];
        }

        int right = 1;
        for (int r = len - 1; r >= 0; r--) {
            ans[r] *= right;
            right *= nums[r];
        }
        return ans;
    }
}
