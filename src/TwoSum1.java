//Given an array of integers, return indices of the two numbers such that they add up to a specific target.

import java.util.*;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] numberArray = {2, 7, 11, 15};
        int targetNum = 9;

        int[] result = calculate(numberArray, targetNum);
        if (result[0] + result[1] == targetNum) {
            for (int i = 0; i < result.length; i++) {
                System.out.print("[" + result[0] + ", " + result[1] + "]");
            }
        } else {
            System.out.print("No result!");
        }
    }

    public static int[] calculate(int[] numberArray, int targetNum) {
//----------O(n^2)-----------------//
//        int[] result = new int[2];
//
//        for(int i = 0; i < numberArray.length - 1; i ++) {
//            for(int j = i + 1; j < numberArray.length; j ++) {
//                if (numberArray[i] + numberArray[j] == targetNum) {
//                    result[0] = i;
//                    result[1] = j;
//                }
//                break;
//            }
//        }
//
//        return result;

        int[] result = new int[2];

        Map<Integer, Integer> tempHashMap = new HashMap<>();
        for (int i = 0; i < numberArray.length; i++) {
            tempHashMap.put(i, numberArray[i]);
        }

        for (int i = 0; i < tempHashMap.size() - 1; i++) {
            if (tempHashMap.containsValue(targetNum - tempHashMap.get(i))) {
                result[0] = i;
                //result[1] = tempHashMap.containsValue(targetNum - tempHashMap.get(i));
            }
        }

        return result;
    }
}
