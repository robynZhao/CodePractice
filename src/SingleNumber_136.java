import java.util.*;

// Given a non-empty array of integers, every element appears twice except for one.
// Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity.
// Could you implement it without using extra memory?

import java.util.HashMap;

public class SingleNumber_136 {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int result = singleNumber(nums);
        System.out.println(result);
    }

    public static int singleNumber(int[] nums) {
        int result = 0;

        HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i ++) {
            if(hashTable.containsKey(nums[i])) {
                hashTable.put(nums[i], hashTable.get(nums[i]) + 1);
            } else {
                hashTable.put(nums[i], 1);
            }
        }

        for(int i = 0; i < nums.length; i ++){
            if(hashTable.get(nums[i]) == 1) {
                result = nums[i];
            }
        }

        return result;
    }
}
