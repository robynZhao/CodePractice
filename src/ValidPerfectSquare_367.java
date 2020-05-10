//Given a positive integer num,
// write a function which returns True if num is a perfect square else False.

// binary search

public class ValidPerfectSquare_367 {
    public static void main(String[] args) {
        int input = 2147483647;
        boolean result = isPerfectSquare(input);
        System.out.println(result);
    }

    public static boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;

        while(left <= right) {
            long mid = (left + right) / 2;
            if(mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                left = mid + 1;
            }else if(mid * mid > num) {
                right = mid -1;
            }

        }

        return false;
    }
}
