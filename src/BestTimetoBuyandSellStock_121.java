// You are given an array prices
// where prices[i] is the price of a given stock on the ith day.
//
// You want to maximize your profit
// by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
// Return the maximum profit you can achieve from this transaction.
// If you cannot achieve any profit, return 0.

public class BestTimetoBuyandSellStock_121 {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        // int[] prices = {7,6,4,3,1}; output = 0
        // int[] prices = {7,1,5,3,6,4}; output = 5
        // int[] prices = {1,2}; output = 1
        // int[] prices = {2,4,1}; output = 2

        int result = maxProfit(prices);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int result = 0;

        // 1. make sure to buy first
        // 2. find the largest difference between buy & sell

        int buy = prices[0]; // no matter what happened, first buy
        int sell = -1;


        for(int i = 1; i < prices.length; i ++) {
            // if new < buy
            if(prices[i] < buy) {
                buy = prices[i];
                sell = -1;
            }

            // if new > sell, sell = new
            if(prices[i] > sell) {
                sell = prices[i];
            }

            // check max difference between buy and sell
            if ((sell - buy) > result) {
                result = sell - buy;
            }
        }


        return result;
    }
}
