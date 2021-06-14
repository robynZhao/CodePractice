import java.util.*;


public class test {
    public static  void main(String[] args) {
        int[] numberArray = {3,2,4};
        int targetNum = 6;

        // other test data
        // input = [2, 7, 11, 15], output = 9
        // input = [3,3], output = 6

        int[] result = twoSum(numberArray, targetNum);

        System.out.print("[" + result[0] + ", " + result[1] + "]");
    }
     public static int[] twoSum(int[]array, int target) {
        int[] result = new int[2];

        // HashMap<key-number, value-if it has been used (1-yes, 0-no)> hashMap = new HashMap<> ();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer> ();


        return result;
     }
}
