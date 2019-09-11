//Given an array of integers, return indices of the two numbers such that they add up to a specific target.

import java.util.*;

public class TwoSum1 {
    public static void main() {
        int[] numberArray = {2, 7, 11, 15};
        int targetNum = 9;

        int[] result = calculate(numberArray, targetNum);
        if(result[0] + result[1] == targetNum) {
            for(int i = 0; i < result.length; i ++) {
                System.out.print("[" + result[0] + ", " + result[1] + "]");
            }
        } else {
            System.out.print("No result!");
        }
    }

    public static int[] calculate(int[] numberArray, int targetNum) {
        int[] result = new int[2];

        for(int i = 0; i < numberArray.length - 1; i ++) {
            for(int j = i + 1; j < numberArray.length; j ++) {
                if (numberArray[i] + numberArray[j] == targetNum) {
                    result[0] = numberArray[i];
                    result[1] = numberArray[j];
                }
            }
        }

        return result;
    }
}
