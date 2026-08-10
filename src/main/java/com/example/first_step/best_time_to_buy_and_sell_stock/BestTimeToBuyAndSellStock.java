package com.example.first_step.best_time_to_buy_and_sell_stock;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
//        int [] prices = new int[] {7,1,5,3,6,4};
        int[] prices = new int[]{7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices));
    }


    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
