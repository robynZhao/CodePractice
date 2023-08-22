import java.util.*;

// Given an array of integers,
// return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice.

public class TwoSum_1 {
    public static void main(String[] args) {
        int[] numberArray = {3,2,4};
        int targetNum = 6;

        // other test data
        // input = [2, 7, 11, 15], output = 9
        // input = [3,3], output = 6


        int[] betterMethod = betterMethod(numberArray, targetNum);
        if(betterMethod != null) {
            System.out.println("Better Method: " + "[" + betterMethod[0] + ", " + betterMethod[1] + "]");
        }

        int[] result = twoSum(numberArray, targetNum);
        System.out.print("[" + result[0] + ", " + result[1] + "]");
    }
    public static int[] betterMethod(int[] input, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < input.length; i ++) {
            if(!map.containsKey(target - input[i])) {
                map.put(input[i], i);
            } else {
                return new int[]{i, map.get(target - input[i])};
            }
        }
        return null;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // int[appear times, position 0, position 1]
        // if a num only appear one time, the position 1 == -1
        HashMap<Integer, int[]> hashNums = new HashMap<> ();

        for(int i = 0; i < nums.length; i ++) {
            if(hashNums.containsKey(nums[i])) {
                int[] tempValue = hashNums.get(nums[i]);
                if(tempValue[0] < 2) {
                    tempValue[0] += 1;
                    tempValue[2] = i;
                    hashNums.put(nums[i], tempValue);
                }
            } else {
                hashNums.put(nums[i], new int[]{1, i, -1});
            }
        }

        for(int i = 0; i < nums.length; i ++) {
            int different = target - nums[i];

            if(nums[i] != different && hashNums.containsKey(different)) {
                int[] tempValue = hashNums.get(nums[i]);
                if(tempValue[0] == 2) {
                    result[0] = tempValue[1];
                    result[1] = tempValue[2];
                } else {
                    if(nums[i] != different) {
                        result[0] = hashNums.get(nums[i])[1];
                        result[1] = hashNums.get(different)[1];
                    }
                }
                break;
            } else if(nums[i] == different && hashNums.containsKey(different)) {
                int[] tempValue = hashNums.get(nums[i]);
                if(tempValue[0] == 2) {
                    result[0] = tempValue[1];
                    result[1] = tempValue[2];
                    break;
                }
            }
        }

        return result;
    }
}
