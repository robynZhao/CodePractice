
// Given an array of size n, find the majority element.
// The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.

import java.util.HashMap;

public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = {2,3,3};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        int result = 0;
        // <number, appear times>
        HashMap<Integer, Integer> hashNums = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            hashNums.put(nums[i], hashNums.getOrDefault(nums[i], 0) + 1);
            if(hashNums.getOrDefault(nums[i], 0) > nums.length / 2) {
                return nums[i];
            }
        }

        return result;
    }
}
