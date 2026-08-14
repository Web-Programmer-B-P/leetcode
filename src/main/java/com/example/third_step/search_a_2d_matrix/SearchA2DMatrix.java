package com.example.third_step.search_a_2d_matrix;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 * <p>
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                };
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        int left = 0;
        int right = total - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
