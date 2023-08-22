
// Given an integer array nums, find the contiguous subarray (at least one number)
// which has the largest sum and return its sum.
// Follow up: If you have figured out the O(n) solution,
// try coding another solution using the divide and conquer approach, which is more subtle.

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Result: " + maxSubArray(input));
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int tempSum = 0;

        for (int num : nums) {
            tempSum = Math.max(0, tempSum) + num;
            sum = Math.max(tempSum, sum);
        }

        return sum;
    }
}
