import java.util.*;

// Given an array of stock market prices for a single day,
// output the highest single-day profit that could have been made.
// Assume that you must buy at some point in time, and sell at a
// later time.
//
// Example signature:
//
//    public int MaxOneDayProfit( int[] prices )
//
// Example test cases:
//
//    MaxOnedayProfit( [100, 200, 300] ) = 200
//    MaxOnedayProfit( [100, 200, 150] ) = 100
//    MaxOnedayProfit( [150, 200, 100] ) = 50

public class HighestSingleDayProfit {
    public static void main(String[] args) {
        int [] prices = {100, 200, 300};

        if(prices.length < 2) {
            System.out.println("Price list must contain at least 2 values");
        } else {
            System.out.println(MaxOneDayProfit(prices));
        }
    }

    public static int MaxOneDayProfit( int[] prices ) {
        int profit = 0;
        int buy_price = prices[0];

        profit = prices[0] - prices[1];

        for(int i = 1; i < prices.length; i ++) {
            if(buy_price > prices[i] ) {
                buy_price = prices[i];
            }
            if(profit < prices[i] - buy_price) {
                profit = prices[i] - buy_price;
            }
        }

        return profit;
    }
}
