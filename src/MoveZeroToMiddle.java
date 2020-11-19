// given a int list, move all 0 to the middle of other int, and keep the other int order unchanged

import java.util.ArrayList;
import java.util.List;

public class MoveZeroToMiddle {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();

        //input option 1: 0 or 1 ==> 0 or 1
        // input option 2: 0,1 or 1,0 ==> 0,1 or 0,1
        // input option 3: 0,0,0,0,-1,-3,-9 ==> -1, 0, 0, 0, 0, -3, -9
        // input option 4: 1,0,2,0,3,0,4,0,5 ==> 1, 2, 0, 0, 0, 0, 3, 4, 5
        // input option 5: 1,2,3,0,0 ==> 1, 0, 0, 2, 3
        // input option 6: 0,1,1,3 ==> 1, 0, 1, 3

        input.add(1);
        input.add(0);
        input.add(2);
        input.add(0);
        input.add(3);
        input.add(0);
        input.add(4);
        input.add(0);
        input.add(5);

        // System.out.println(input);

        System.out.println(arrange(input));
    }

    public static List<Integer> arrange(List<Integer> input) {

        if(input.size() == 0 || input.size() == 1) {
            return input;
        }

        List<Integer> result = new ArrayList<Integer>();

        // go through input, and record number of zeros
        int zeroNumber = 0;
        for(int i = 0; i < input.size(); i ++) {
            if(input.get(i) == 0) {
                zeroNumber ++;
            } else {
                result.add(input.get(i));
            }
        }

        // System.out.println(zeroNumber);

        // add zero to the middle of result arraylist
        for(int i = 0; i < zeroNumber; i ++) {
            int center = result.size() / 2;
            result.add(center, 0);
        }

        return result;
    }
}
