// You are given an m x n integer grid accounts
// where accounts[i][j] is the amount of money the i-th customer has in the j-th bank.
// Return the wealth that the richest customer has.
//
// A customer's wealth is the amount of money they have in all their bank accounts.
// The richest customer is the customer that has the maximum wealth.

public class RichestCustomerWealth_1672 {
    public static void main(String[] args) {

        int[][] accounts = {{1,2,3}, {3,2,1}};
        // input accounts = {{1,5}, {7,3}, {3,5}}; output = 10

        int result = maximumWealth(accounts);
        System.out.println(result);
    }

    public static int maximumWealth(int[][] accounts) {
        int result = 0;

        for(int row = 0; row < accounts.length; row ++) {
            int temp = 0;
            for(int col = 0; col < accounts[0].length; col ++) {
                temp += accounts[row][col];

                if(temp > result) {
                    result = temp;
                }
            }
        }

        return result;
    }
}
