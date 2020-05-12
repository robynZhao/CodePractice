// You are given a sorted array consisting of only integers where every element appears exactly twice,
// except for one element which appears exactly once. Find this single element that appears only once.

public class SingleElementInASortedArray_540 {
    public static void main(String[] args) {
        int[] input = {1,1,2,3,3,4,4,8,8};
        int result = singleNonDuplicate(input);
        System.out.println(result);
    }

    public static int singleNonDuplicate(int[] nums) {
        int result = -1;
        for(int i = 0; i < nums.length - 1; i ++) {
            if(nums[i] == nums[i + 1]) {
                i ++;
            } else {
                result = nums[i];
            }
        }
        if(result == -1) {
            result = nums[nums.length - 1];
        }

        return result;
    }
}
