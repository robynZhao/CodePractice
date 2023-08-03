// There is an array of n integers called nums. The array can be reduced by one element by performing a move operation.
//
//Each move has:
//  Pick two different elements nums[i] and nums[j] (i and j are not equal)
//  Remove both elements
//  Add the sum of two selected elements to the end of the array
//Each move has a cost associated with it – the sum of 2 elements removed from the array during the move.
//Hence, calculate the minimum total cost of reducing the array to one element.
//
//Input: nums array containing n elements
//Output: Integer value displaying the minimum cost
//
//Input: [4, 6, 8]
//Output: 28
//
//Input: [4, 4, 4, 4, 6]
//Output: 52
//
//Input: [1, 2, 3, 4]
//Output: 19

//Input: [1, 4, 7, 10]
//Output: 39
//
//Input: [1, 3, 7, 5, 6]
//Output: 48

import java.util.*;

public class ArrayReduction {
    public static void main(String[] args) {
        int[] input = {5, 5, 5, 5};
        System.out.println(getMinSum(input));
    }

    public static int getMinSum(int[] input) {
        int result = 0;
        ArrayList<Integer> input_list = new ArrayList<>();

        // convert input to ArrayList
        // sort the ArrayList
        for(int i = 0; i < input.length; i ++) {
            input_list.add(input[i]);
            Collections.sort(input_list);
        }
        int length = input_list.size();

        while(length > 2) {
            int two_min_sum = input_list.get(0) + input_list.get(1);

            result += two_min_sum;

            input_list.remove(1);
            input_list.remove(0);
            input_list.add(two_min_sum);
            Collections.sort(input_list);

            length = input_list.size();
        }

        result += input_list.get(0) + input_list.get(1);

        return result;
    }
}
