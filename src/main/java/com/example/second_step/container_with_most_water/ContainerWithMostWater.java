package com.example.second_step.container_with_most_water;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }


    public static int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int leftReference = 0;
        int rightReference = height.length - 1;
        int maxSquare = 0;

        while (leftReference < rightReference) {
            int minHeight = Math.min(height[leftReference], height[rightReference]);
            int currentSquare = minHeight * (rightReference - leftReference);
            maxSquare = Math.max(maxSquare, currentSquare);

            /*Сдвигаемся не на один шаг как в классическом решении, а пропускаем сразу группами.
            * Аналогичным способом отрабатывали поиск дубликатов в задаче 3Sum*/
            while (leftReference < rightReference && height[leftReference] <= minHeight) {
                leftReference++;
            }
            while (leftReference < rightReference && height[rightReference] <= minHeight) {
                rightReference--;
            }
        }

        return maxSquare;
    }
}
