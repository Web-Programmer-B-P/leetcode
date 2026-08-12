package com.example.second_step.remove_duplicates_from_sorted_array;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
 * element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Consider the number of unique elements in nums to be k.
 * After removing duplicates, return the number of unique elements k.
 * <p>
 * The first k elements of nums should contain the unique numbers in sorted order.
 * The remaining elements beyond index k - 1 can be ignored.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return nums.length;
        }

        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
}
