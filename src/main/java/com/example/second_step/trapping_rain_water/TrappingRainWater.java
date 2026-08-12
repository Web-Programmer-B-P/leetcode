package com.example.second_step.trapping_rain_water;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        int diff;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                diff = leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                diff = rightMax - height[right];
            }
            if (diff > 0) {
                water += diff;
            }
        }

        return water;
    }
}
