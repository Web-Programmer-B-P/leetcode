package com.example.third_step.koko_eating_bananas;

import java.util.Arrays;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k.
 * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 0) {
            return 0;
        }
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canEat(int[] piles, int h, int speedOfCanEat) {
        int totalHours = 0;
        for (int colOfBananasInHeap : piles) {
            totalHours += (colOfBananasInHeap + speedOfCanEat - 1) / speedOfCanEat; // ceil(colOfBananasInHeap/speedOfCanEat)
        }
        return totalHours <= h;
    }
}
